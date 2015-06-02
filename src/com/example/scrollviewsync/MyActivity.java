package com.example.scrollviewsync;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyActivity extends Activity implements ObservableScrollView.ScrollViewListener {
   private LinearLayout mMainLayout;

   private ObservableScrollView mLeftScrollView;
   private ObservableScrollView mRightScrollView;

   private Container mLeftContainer;
   private Container mRightContainer;

   boolean mInterceptTouch = true;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
   }

   @Override
   public View onCreateView(String name, Context context, AttributeSet attrs) {
      return super.onCreateView(name, context, attrs);
   }

   @Override
   protected void onStart() {
      super.onStart();

      getActionBar().hide();

      mMainLayout = (LinearLayout) findViewById(R.id.main_layout);
      mMainLayout.setOrientation(LinearLayout.HORIZONTAL);
      mLeftScrollView = (ObservableScrollView) findViewById(R.id.left_scrollview);
      mRightScrollView = (ObservableScrollView) findViewById(R.id.right_scrollview);

      mLeftContainer = (Container) findViewById(R.id.left_container);
      mRightContainer = (Container) findViewById(R.id.right_container);
      mLeftContainer.fillWithSquares();
      mRightContainer.fillWithSquares();

      mLeftScrollView.setScrollViewListener(this);
      mRightScrollView.setScrollViewListener(this);
   }

   @Override
   public void onScrollChanged(ObservableScrollView scrollView, int x, int y, int oldx, int oldy) {
      if (mInterceptTouch == true) {
         mInterceptTouch = false;
         if (scrollView == mLeftScrollView) {
            mRightScrollView.setScrollY(y);
         } else {
            mLeftScrollView.setScrollY(y);
         }
         mInterceptTouch = true;
      }
   }
}
