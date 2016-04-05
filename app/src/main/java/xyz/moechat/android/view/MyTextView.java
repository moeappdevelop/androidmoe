package xyz.moechat.android.view;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.text.Selection;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by timeloveboy on 16/3/29.
 */
public class MyTextView extends EditText {
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }
    private   void  initialize() {
        setGravity(Gravity.TOP);
        setBackgroundColor(Color.WHITE);
    }
    private   int  off;  //字符串的偏移值

//    @Override
//    protected   void  onCreateContextMenu(ContextMenu menu) {
//        //不做任何处理，为了阻止长按的时候弹出上下文菜单
//    }

    @Override
    public   boolean  getDefaultEditable() {
        return   false ;
    }
    @Override
    protected MovementMethod getDefaultMovementMethod() {
        return   null ;
    }
    @Override
    public   boolean  onTouchEvent(MotionEvent event) {
        int  action = event.getAction();
        Layout layout = getLayout();
        int  line =  0 ;
        switch (action) {
            case  MotionEvent.ACTION_DOWN:
                line = layout.getLineForVertical(getScrollY()+ (int )event.getY());
                off = layout.getOffsetForHorizontal(line, (int )event.getX());
                Selection.setSelection(getEditableText(), off);
                break ;
            case  MotionEvent.ACTION_MOVE:
            case  MotionEvent.ACTION_UP:
                line = layout.getLineForVertical(getScrollY()+(int )event.getY());
                int  curOff = layout.getOffsetForHorizontal(line, ( int )event.getX());
                Selection.setSelection(getEditableText(), off, curOff);
                break ;
        }
        return   true ;
    }
}
