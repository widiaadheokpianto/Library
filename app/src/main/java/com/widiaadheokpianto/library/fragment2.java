package com.widiaadheokpianto.library;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragment2 extends Fragment
{
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
       View view_frag2 = inflater.inflate(R.layout.fragment2, container, false);
       return view_frag2;
   }
}
