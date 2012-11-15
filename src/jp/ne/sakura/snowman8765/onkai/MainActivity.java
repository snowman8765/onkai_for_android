package jp.ne.sakura.snowman8765.onkai;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	private WebView webView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webView = (WebView)findViewById(R.id.webView1);
		webView.setWebViewClient(new WebViewClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("http://snowman8765.sakura.ne.jp/onkai/index.php");
	}

	@Override
	public boolean onKeyDown( int keyCode, KeyEvent event ) {
		if ( event.getAction() == KeyEvent.ACTION_DOWN
				&& keyCode == KeyEvent.KEYCODE_BACK
				&& webView.canGoBack() == true ) {
			webView.goBack();
			return true;
		}
		return super.onKeyDown( keyCode, event );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu,menu);
		return true;
	}
	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		super.onPrepareOptionsMenu(menu);
		if(webView.canGoBack()){
			menu.findItem(R.id.item1).setEnabled(true);
		}else{
			menu.findItem(R.id.item1).setEnabled(false);
		}
		if(webView.canGoForward()){
			menu.findItem(R.id.item2).setEnabled(true);
		}else{
			menu.findItem(R.id.item2).setEnabled(false);
		}
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		case R.id.item1:
			webView.goBack();
			break;
		case R.id.item2:
			webView.goForward();
			break;
		case R.id.item3:
			finish();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
