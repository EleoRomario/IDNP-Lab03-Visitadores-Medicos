package com.lab03.visitadoresmedicos.models;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
    @BindingAdapter("visibility")
    public static void showEmptyState(View v, boolean show) {
        v.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
