package sjy.skylmssend.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

import co.kr.sky.AccumThread;
import sjy.skylmssend.R;
import sjy.skylmssend.common.CommonUtil;
import sjy.skylmssend.common.FragmentEx;


@SuppressLint("ValidFragment")
public class LMSFragment extends FragmentEx {

    //Object
    private Activity av;
    private Context cv;

    //Instance
    CommonUtil dataSet = CommonUtil.getInstance();

    //SKY
    private AccumThread mThread;
    private Map<String, String> map = new HashMap<String, String>();

    @SuppressLint("ValidFragment")
    public LMSFragment(Activity av, Context cv) {
        // Required empty public constructor
        this.av = av;
        this.cv = cv;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("SKY" , "--onCreate--");
    }


    //"COM_NM":"橋本工業" 회사 이름! 추가 할것!
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("SKY" , "--onCreateView--");
        View view = inflater.inflate(R.layout.fragment_lms, container , false);

        return view;

    }
}
