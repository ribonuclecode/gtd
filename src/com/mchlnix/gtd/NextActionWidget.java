package com.mchlnix.gtd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NextActionWidget extends LinearLayout {

	public NextActionWidget(Context context, String text ) {
		super(context);

		this.setOrientation( LinearLayout.HORIZONTAL );

		TextView action = new TextView( context );
		action.setText( text );
		action.setTextAppearance( context, android.R.style.TextAppearance_Large );
		action.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1 ) );

		this.addView( action );

		ImageView remove = new ImageView( context );

		remove.setImageResource( R.drawable.check );
		remove.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
		remove.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				((LinearLayout) v.getParent().getParent()).removeView( (View) v.getParent() );

			}
		});

		this.addView( remove );
	}

}
