package maurizionapoleoni.de.japaneselearningkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard hKeyboard;
    private Keyboard kKeyboard;
    private Keyboard qKeyboard;

    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        InputConnection ic = getCurrentInputConnection();

        switch (primaryCode) {
            case Keyboard.KEYCODE_DELETE:
                ic.deleteSurroundingText(1, 0);
                break;

            case -7:
                kv.setKeyboard(kKeyboard);
                kv.invalidateAllKeys();
                break;

            case -8:
                kv.setKeyboard(qKeyboard);
                kv.invalidateAllKeys();
                break;
            case -9:
                kv.setKeyboard(hKeyboard);
                kv.invalidateAllKeys();
                break;
            default:
                char code = (char) primaryCode;
                ic.commitText(String.valueOf(code), 1);

        }
    }

    @Override
    public void onPress(int primaryCode) {
    }

    @Override
    public void onRelease(int primaryCode) {
    }

    @Override
    public void onText(CharSequence text) {
    }

    @Override
    public void swipeDown() {
    }

    @Override
    public void swipeLeft() {
    }

    @Override
    public void swipeRight() {
    }

    @Override
    public void swipeUp() {
    }

    @Override
    public View onCreateInputView() {
        kv = (KeyboardView)getLayoutInflater().inflate(R.layout.keyboard, null);
        hKeyboard = new Keyboard(this, R.xml.hiragana);
        kKeyboard = new Keyboard(this, R.xml.katakana);
        qKeyboard = new Keyboard(this, R.xml.qwerty);
        kv.setKeyboard(hKeyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

}
