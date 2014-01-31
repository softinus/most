package com.softinus.most;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.softinus.most.dummy.AdjectiveContent;
import com.softinus.most.dummy.AdjectiveContent.AdjectiveItem;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the
 * ListView with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class Item1_Fragment extends Fragment implements
		AbsListView.OnItemClickListener {

	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;

	private OnFragmentInteractionListener mListener;

	/**
	 * The fragment's ListView/GridView.
	 */
	private AbsListView mListView;

	/**
	 * The Adapter which will be used to populate the ListView/GridView with
	 * Views.
	 */
	private ListAdapter mAdapter;

	// TODO: Rename and change types of parameters
	public static Item1_Fragment newInstance(String param1, String param2) {
		Item1_Fragment fragment = new Item1_Fragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public Item1_Fragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}

		// TODO: Change Adapter to display your content
		mAdapter = new ArrayAdapter<AdjectiveContent.AdjectiveItem>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1, AdjectiveContent.ITEMS);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_item, container, false);

		// Set the adapter
		mListView = (AbsListView) view.findViewById(android.R.id.list);
		((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

		// Set OnItemClickListener so we can be notified on item clicks
		mListView.setOnItemClickListener(this);

		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		if (null != mListener)
		{
			// Notify the active callbacks interface (the activity, if the
			// fragment is attached to one) that an item has been selected.
			mListener
					.onFragmentInteraction(AdjectiveContent.ITEMS.get(position).id);
		}
		
		String strTitle1="세상에서 가장 ";
		SearchActivity thisActivity= (SearchActivity) getActivity();
		switch(position)
		{
		case 0:			
			thisActivity.setTitle(strTitle1+"빠른");
			break;
		case 1:			
			thisActivity.setTitle(strTitle1+"높은(큰)");
			break;
		case 2:			
			thisActivity.setTitle(strTitle1+"무거운");
			break;
		case 3:			
			thisActivity.setTitle(strTitle1+"비싼");
			break;
		case 4:			
			thisActivity.setTitle(strTitle1+"느린");
			break;
		case 5:			
			thisActivity.setTitle(strTitle1+"낮은(작은)");
			break;
		case 6:			
			thisActivity.setTitle(strTitle1+"가벼운");
			break;
		case 7:			
			thisActivity.setTitle(strTitle1+"값싼");
			break;
		}
		thisActivity.bAdjSelected= true;
	}

	/**
	 * The default content for this Fragment has a TextView that is shown when
	 * the list is empty. If you would like to change the text, call this method
	 * to supply the text it should use.
	 */
	public void setEmptyText(CharSequence emptyText) {
		View emptyView = mListView.getEmptyView();

		if (emptyText instanceof TextView) {
			((TextView) emptyView).setText(emptyText);
		}
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onFragmentInteraction(String id);
	}

}
