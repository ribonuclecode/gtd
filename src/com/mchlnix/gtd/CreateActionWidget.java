package com.mchlnix.gtd;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CreateActionWidget extends LinearLayout {

	EditText edit;
	Context context;

	public CreateActionWidget(Context context) {
		super(context);

		this.context = context;

		this.edit = new EditText( context );
		this.edit.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1 ) );
		this.setMinimumHeight( 80 );

		this.edit.requestFocus();

		this.setOrientation( LinearLayout.HORIZONTAL );

		this.addView( edit );

		ImageView add = new ImageView( context );
		add.setImageResource( android.R.drawable.ic_input_add );
		add.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {
				createNextAction( v );
			}
		});

		this.addView( add );
	}

	protected void createNextAction( View v ) {
		LinearLayout list = (LinearLayout) v.getParent().getParent();

		int position = list.indexOfChild( (View) v.getParent() );
		String action = this.edit.getText().toString();

		if ( action.trim().isEmpty() )
			return;

		//list.removeViewAt( position );
		list.addView( new NextActionWidget( this.context, this.edit.getText().toString() ), position-1 );
		this.edit.setText("");

	}

}
