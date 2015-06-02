package com.example.scrollviewsync;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Container extends ViewGroup {
   final int WIDTH = 300;
   final int HEIGHT = 72;
   final int CONTENT_HEIGHT = 10000;

   public Container(Context context) {
      super(context);
   }

   public Container(Context context, AttributeSet attrs) {
      super(context, attrs);
   }

   public Container(Context context, AttributeSet attrs, int defStyleAttr) {
      super(context, attrs, defStyleAttr);
   }

   public Container(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
      super(context, attrs, defStyleAttr, defStyleRes);
   }

   void fillWithSquares() {
      final int rowCount = CONTENT_HEIGHT / HEIGHT;
      final int colCount = 5;

      for (int row = 0; row < rowCount; ++row) {
         for (int col = 0; col < colCount; ++col) {
            addView(createDummySquare(row, col));
         }
      }
   }

   @Override
   protected void onLayout(boolean changed, int l, int t, int r, int b) {

   }

   @Override
   protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      setMeasuredDimension(CONTENT_HEIGHT, CONTENT_HEIGHT);
   }

   View createDummySquare(int row, int col) {
      View dummySquare = new View(getContext());
      dummySquare.measure(View.MeasureSpec.makeMeasureSpec(WIDTH - 2, View.MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(HEIGHT - 2, View.MeasureSpec.EXACTLY));
      dummySquare.layout(0, 0, dummySquare.getMeasuredWidth(), dummySquare.getMeasuredHeight());
      dummySquare.setBackgroundColor(Color.BLUE);
      dummySquare.setTranslationX(col * WIDTH);
      dummySquare.setTranslationY(row * HEIGHT);
      return dummySquare;
   }
}
