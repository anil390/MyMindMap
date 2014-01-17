package com.anil.android.mymindmap;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
 

public class ToolsActivity extends Activity {
	
	public String selectedShape = "Rectangle";
	public String selectedSize = "small";
	
	private RadioGroup toolsRG;
	private RadioButton rectRB;
	private RadioButton ellipseRB;
	private RadioButton lineRB;
	private ImageView selectedImage;
	private SeekBar seekBar;
	private TextView seekBarValue;
	private Button selectionDone;
	
	
	 
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_tools);
	        ActionBar actionBar = getActionBar();
	   	 
	        // Enabling Up / Back navigation
	        actionBar.setDisplayHomeAsUpEnabled(true);
	        seekBar = (SeekBar)findViewById(R.id.seekBar1); 
	        seekBarValue = (TextView)findViewById(R.id.seekbarTV); 
	        selectedImage = (ImageView) findViewById(R.id.imageView1);
	        toolsRG = (RadioGroup) findViewById(R.id.radioTools);
	        rectRB = (RadioButton) findViewById(R.id.radioRect);
	        ellipseRB = (RadioButton) findViewById(R.id.radioEllipse);
	        lineRB = (RadioButton) findViewById(R.id.radioLine);
	        selectionDone = (Button)findViewById(R.id.selectedBTN);
	        
	        selectionDone.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent data = new Intent();
					data.putExtra("shape", selectedShape);
					data.putExtra("size", selectedSize);
					setResult(RESULT_OK, data);
					finish();
					
					
				}
			});
	        
	        
	        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

		        	   @Override 
		        	   public void onProgressChanged(SeekBar seekBar, int progress, 
		        	     boolean fromUser) { 
								        		   if(progress < 33)
								        		   {
								        			   seekBarValue.setText("Small"); 
								        			   selectedSize = "Small";
								        		   }
								        		   else if(progress < 67)
								        		   {
								        			   seekBarValue.setText("Medium"); 
								        			   selectedSize = "Medium";
								        		   }
								        		   else
								        		   {
								        			   seekBarValue.setText("Large");  
								        			   selectedSize = "Large";
								        		   }
		        	   
		        	   					} 
		        	   
	
							        	   @Override 
							        	   public void onStartTrackingTouch(SeekBar seekBar) { 
							        	   } 
						
							        	   @Override 
							        	   public void onStopTrackingTouch(SeekBar seekBar) { 
							        	   } 
							       });
	        
	        
	        
	        
	        
	        
	        toolsRG.setOnCheckedChangeListener(new OnCheckedChangeListener() {
	            public void onCheckedChanged(RadioGroup rg, int checkedId) {
	                if (rectRB.getId() == checkedId) {
	                	selectedImage.setImageDrawable(null);
	                	selectedShape = "Rectangle";
	                    //ellipseSelected();
	                    
	                    return;
	                } else if (ellipseRB.getId() == checkedId) {
	                   // warnMethod();
	                	selectedShape = "Ellipse";
	                    return;
	                } else if (lineRB.getId() == checkedId) {
	                   // greyMethod();
	                	selectedShape = "Line";
	                    return;
	                }
	            }
	        });
	    
	        
	        
	        
	        // get action bar  
	       
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	    }
	}
