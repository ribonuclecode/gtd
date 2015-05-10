package com.mchlnix.gtd;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionWidget extends LinearLayout {

	public ActionWidget(Context context, String text ) {
		super(context);

		this.setOrientation( LinearLayout.HORIZONTAL );
		this.setPadding( this.getPaddingLeft(),
				this.getPaddingTop(),
				this.getPaddingRight()+5,
				this.getPaddingBottom()+5 );

		TextView action = new TextView( context );

		LayoutParams params = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1 );
		params.gravity = Gravity.CENTER_VERTICAL;

		action.setText( text );
		action.setLayoutParams( params );

		this.addView( action );

		ImageView remove = new ImageView( context );

		params = new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT );
		params.gravity = Gravity.CENTER_VERTICAL;

		remove.setImageResource( R.drawable.check );
		remove.setLayoutParams( params );
		remove.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				((LinearLayout) v.getParent().getParent()).removeView( (View) v.getParent() );

			}
		});

		this.addView( remove );
	}

}
