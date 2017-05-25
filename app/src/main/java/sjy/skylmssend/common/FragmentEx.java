package sjy.skylmssend.common;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

import sjy.skylmssend.R;


public class FragmentEx extends Fragment {
	protected ProgressDialog  customDialog = null;



	@SuppressLint("ValidFragment")
	public FragmentEx() {
	}

	public void customProgressPop(){
		try{
			if (customDialog==null){
				customDialog = new ProgressDialog( getContext() , ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
				customDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				customDialog.setMessage(getString(R.string.loading_txt));
				customDialog.show();
			}
		}catch(Exception ex){}
	}
	public void customProgressClose(){
		if (customDialog!=null && customDialog.isShowing()){
			try{
				customDialog.cancel();
				customDialog.dismiss();
				customDialog = null;
			}catch(Exception e)
			{}
		}
	}


}
