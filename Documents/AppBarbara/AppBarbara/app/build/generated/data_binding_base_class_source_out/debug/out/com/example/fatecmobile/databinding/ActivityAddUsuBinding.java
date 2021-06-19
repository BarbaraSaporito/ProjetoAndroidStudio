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

public final class ActivityAddUsuBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btinserir;

  @NonNull
  public final EditText login;

  @NonNull
  public final EditText senha;

  @NonNull
  public final EditText status;

  @NonNull
  public final EditText tipo;

  private ActivityAddUsuBinding(@NonNull LinearLayout rootView, @NonNull Button btinserir,
      @NonNull EditText login, @NonNull EditText senha, @NonNull EditText status,
      @NonNull EditText tipo) {
    this.rootView = rootView;
    this.btinserir = btinserir;
    this.login = login;
    this.senha = senha;
    this.status = status;
    this.tipo = tipo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddUsuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddUsuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_usu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddUsuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btinserir;
      Button btinserir = rootView.findViewById(id);
      if (btinserir == null) {
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

      id = R.id.status;
      EditText status = rootView.findViewById(id);
      if (status == null) {
        break missingId;
      }

      id = R.id.tipo;
      EditText tipo = rootView.findViewById(id);
      if (tipo == null) {
        break missingId;
      }

      return new ActivityAddUsuBinding((LinearLayout) rootView, btinserir, login, senha, status,
          tipo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
