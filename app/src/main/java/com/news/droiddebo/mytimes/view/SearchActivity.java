package com.news.droiddebo.mytimes.view;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.news.droiddebo.mytimes.MyTimesApplication;
import com.news.droiddebo.mytimes.R;
import com.news.droiddebo.mytimes.adapter.DataAdapter;
import com.news.droiddebo.mytimes.model.ArticleStructure;
import com.news.droiddebo.mytimes.model.Constants;
import com.news.droiddebo.mytimes.model.NewsResponse;
import com.news.droiddebo.mytimes.network.ApiClient;
import com.news.droiddebo.mytimes.network.ApiInterface;
import com.news.droiddebo.mytimes.network.interceptors.OfflineResponseCacheInterceptor;
import com.news.droiddebo.mytimes.network.interceptors.ResponseCacheInterceptor;

import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {


}
