package maurizionapoleoni.de.japaneselearningkeyboard;

import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;


public class SimpleIME extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    private KeyboardView kv;
    private Keyboard hkeyboard;
    private Keyboard kKeyboard;

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
                kv.setKeyboard(hkeyboard);
                kv.invalidateAllKeys();
                break;

            case Keyboard.KEYCODE_DONE:
                ic.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
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
        hkeyboard = new Keyboard(this, R.xml.hiragana);
        kKeyboard = new Keyboard(this, R.xml.katakana);
        kv.setKeyboard(hkeyboard);
        kv.setOnKeyboardActionListener(this);
        return kv;
    }

}
