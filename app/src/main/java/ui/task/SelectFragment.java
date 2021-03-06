package ui.task;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.shxy.dazuoye.R;


public class SelectFragment extends Fragment implements View.OnClickListener {

    private Button ok, next;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fa_task_s1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        ok = (Button) getActivity().findViewById(R.id.ok);
        next = (Button) getActivity().findViewById(R.id.next);
        ok.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok:
                if (listener != null)
                    listener.ok(Listener.STATE_OK);
                break;
            case R.id.next:
                if (listener != null)
                    listener.ok(Listener.STATE_NEXT);
                break;
        }
    }

    public interface Listener {
        int STATE_OK = 1;
        int STATE_NEXT = 2;

        void ok(int state);
    }

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
