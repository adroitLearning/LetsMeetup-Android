// Generated by view binder compiler. Do not edit!
package aculix.meetly.app.databinding;

import aculix.meetly.app.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final EditText edtLogindata;

  @NonNull
  public final EditText edtPassword;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final Button login;

  @NonNull
  public final TextView tvSignup;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull EditText edtLogindata,
      @NonNull EditText edtPassword, @NonNull ImageView imageView2, @NonNull Button login,
      @NonNull TextView tvSignup) {
    this.rootView = rootView;
    this.edtLogindata = edtLogindata;
    this.edtPassword = edtPassword;
    this.imageView2 = imageView2;
    this.login = login;
    this.tvSignup = tvSignup;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.edt_logindata;
      EditText edtLogindata = rootView.findViewById(id);
      if (edtLogindata == null) {
        break missingId;
      }

      id = R.id.edt_password;
      EditText edtPassword = rootView.findViewById(id);
      if (edtPassword == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = rootView.findViewById(id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.login;
      Button login = rootView.findViewById(id);
      if (login == null) {
        break missingId;
      }

      id = R.id.tv_signup;
      TextView tvSignup = rootView.findViewById(id);
      if (tvSignup == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, edtLogindata, edtPassword,
          imageView2, login, tvSignup);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
