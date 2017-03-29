package Base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class BaseActivity extends Activity implements IHandlerListener{
	public Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			OnHandlerListener(msg);
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public void OnHandlerListener(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler mHandler) {
		this.handler = mHandler;
	}

}
