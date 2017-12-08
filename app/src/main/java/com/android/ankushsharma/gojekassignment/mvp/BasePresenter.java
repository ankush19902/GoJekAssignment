package com.android.ankushsharma.gojekassignment.mvp;

/**
 *
 * @author ankushsharma
 * @date 08/12/17
 */

public abstract class BasePresenter<V>  {

    protected final V view;

    public BasePresenter(V view) {
        this.view = view;
    }
}
