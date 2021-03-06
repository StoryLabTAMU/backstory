package tamu.backstory;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MessagePromptEndBadgeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MessagePromptEndBadgeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MessagePromptEndBadgeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MessagePromptEndBadgeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MessagePromptEndBadgeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MessagePromptEndBadgeFragment newInstance(String param1, String param2) {
        MessagePromptEndBadgeFragment fragment = new MessagePromptEndBadgeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_message_prompt_end_badge, container, false);
        int missionNumber = MessagePromptEnd.missionNumber;
        if(missionNumber == 0){
            setBadgeText1(v);
        } else if(missionNumber == 1){
            setBadgeText2(v);
        } else {
            setBadgeText3(v);
        }
        return v;
    }

    public void setBadgeText1(View v){
        TextView badgeText = (TextView) v.findViewById(R.id.badgeDescriptionText);
        String text = "Awesome! Good job on your recordings.";
        badgeText.setText(text);
        ImageView achievement = (ImageView) v.findViewById(R.id.badgeImage);
        achievement.setImageResource(R.drawable.achievement_medal);
    }

    public void setBadgeText2(View v){
        TextView badgeText = (TextView) v.findViewById(R.id.badgeDescriptionText);
        String text = "Excellent! You know a lot about science.";
        badgeText.setText(text);
        ImageView achievement = (ImageView) v.findViewById(R.id.badgeImage);
        achievement.setImageResource(R.drawable.achievement_rocket);
    }

    public void setBadgeText3(View v){
        TextView badgeText = (TextView) v.findViewById(R.id.badgeDescriptionText);
        /*
        if(ChapterDataSingleton.getSync(this.getContext()).getTheme().equals("spy")){
            String text = "You've won an award as the best agent of the year";
            badgeText.setText(text);
        }
        else if(ChapterDataSingleton.getSync(this.getContext()).getTheme().equals("adventurer")){
            String text = "People have nominated you as the best explorer";
            badgeText.setText(text);
        }
        else if(ChapterDataSingleton.getSync(this.getContext()).getTheme().equals("journalist")){
            String text = "Agency has just accepted you as the best agent of the year";
            badgeText.setText(text);
        }
        */
        String text = "Fantastic! You sound like a real scientist.";
        badgeText.setText(text);
        ImageView achievement = (ImageView) v.findViewById(R.id.badgeImage);
        achievement.setImageResource(R.drawable.achievement_badge);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
