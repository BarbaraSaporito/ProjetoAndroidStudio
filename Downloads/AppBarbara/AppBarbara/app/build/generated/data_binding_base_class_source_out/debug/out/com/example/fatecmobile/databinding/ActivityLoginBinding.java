// Generated by view binder compiler. Do not edit!
package com.example.fatecmobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.example.fatecmobile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btentrar;

  @NonNull
  public final Button btnovousu;

  @NonNull
  public final EditText login;

  @NonNull
  public final EditText senha;

  private ActivityLoginBinding(@NonNull LinearLayout rootView, @NonNull Button btentrar,
      @NonNull Button btnovousu, @NonNull EditText login, @NonNull EditText senha) {
    this.rootView = rootView;
    this.btentrar = btentrar;
    this.btnovousu = btnovousu;
    this.login = login;
    this.senha = senha;
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
      id = R.id.btentrar;
      Button btentrar = rootView.findViewById(id);
      if (btentrar == null) {
        break missingId;
      }

      id = R.id.btnovousu;
      Button btnovousu = rootView.findViewById(id);
      if (btnovousu == null) {
        break missingId;
      }

      id = R.id.login;
      EditText login = rootView.findViewById(id);
      if (login == null) {
        break missingId;
      }

      id = R.id.senha;
      EditText senha = rootView.findViewById(id);
      if (senha == null) {
        break missingId;
      }

      return new ActivityLoginBinding((LinearLayout) rootView, btentrar, btnovousu, login, senha);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}