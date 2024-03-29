package com.anil.android.mymindmap;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class ColorMixer extends RelativeLayout {
  private static final String SUPERSTATE="superState";
  private static final String COLOR="color";
  private View swatch=null;
  private SeekBar red=null;
  private SeekBar blue=null;
  private SeekBar green=null;
  private OnColorChangedListener listener=null;
  
  public ColorMixer(Context context) {
    super(context);
    
    initMixer(null);
  }
  
  public ColorMixer(Context context, AttributeSet attrs) {
    super(context, attrs);
    
    initMixer(attrs);
  }
  
  public ColorMixer(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    
    initMixer(attrs);
  }
  
  public OnColorChangedListener getOnColorChangedListener() {
    return(listener);
  }
  
  public void setOnColorChangedListener(OnColorChangedListener listener) {
    this.listener=listener;
  }
  
  public int getColor() {
    return(Color.argb(0xFF, red.getProgress(),
                      green.getProgress(), blue.getProgress()));
  }
  
  public void setColor(int color) {
    red.setProgress(Color.red(color));
    green.setProgress(Color.green(color));
    blue.setProgress(Color.blue(color));
  }
  
  private void initMixer(AttributeSet attrs) {
    ((Activity)getContext())
    .getLayoutInflater()
    .inflate(R.layout.colormixer_main, this, true);
    
    swatch=findViewById(R.id.swatch);
        
    red=(SeekBar)findViewById(R.id.red);
    red.setMax(0xFF);
    red.setOnSeekBarChangeListener(onMix);

    green=(SeekBar)findViewById(R.id.green);
    green.setMax(0xFF);
    green.setOnSeekBarChangeListener(onMix);

    blue=(SeekBar)findViewById(R.id.blue);
    blue.setMax(0xFF);
    blue.setOnSeekBarChangeListener(onMix);
    
  /*  if (attrs!=null) {
      int[] styleable=R.styleable.ColorMixer;
      TypedArray a=getContext().obtainStyledAttributes(attrs,
                                                        styleable,
                                                        0, 0);
      
      setColor(a.getInt(R.styleable.ColorMixer_color,
                        0xFFA4C639));
      a.recycle();
    }*/
  }
  
  @Override
  public Parcelable onSaveInstanceState() {
    Bundle state=new Bundle();
    
    state.putParcelable(SUPERSTATE, super.onSaveInstanceState());
    state.putInt(COLOR, getColor());

    return(state);
  }

  @Override
  public void onRestoreInstanceState(Parcelable ss) {
    Bundle state=(Bundle)ss;
    
    super.onRestoreInstanceState(state.getParcelable(SUPERSTATE));

    setColor(state.getInt(COLOR));
  }
  
  private SeekBar.OnSeekBarChangeListener onMix=new SeekBar.OnSeekBarChangeListener() {
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
      int color=getColor();
      
      swatch.setBackgroundColor(color);
      
      if (listener!=null) {
        listener.onColorChange(color);
      }
    }
    
    public void onStartTrackingTouch(SeekBar seekBar) {
      // unused
    }
    
    public void onStopTrackingTouch(SeekBar seekBar) {
      // unused
    }
  };
  
  public interface OnColorChangedListener {
    public void onColorChange(int argb);
  }
}