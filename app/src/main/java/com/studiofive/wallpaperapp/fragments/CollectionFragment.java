package com.studiofive.wallpaperapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.studiofive.wallpaperapp.Adapters.PhotosAdapter;
import com.studiofive.wallpaperapp.Models.Photo;
import com.studiofive.wallpaperapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class CollectionFragment extends Fragment {
    private final String TAG = CollectionFragment.class.getSimpleName();
    @BindView(R.id.fragment_collection_username)
    TextView username;
    @BindView(R.id.fragment_collection_description)
    TextView description;
    @BindView(R.id.fragment_collection_user_avatar)
    CircleImageView userAvatar;
    @BindView(R.id.fragment_collection_title)
    TextView title;
    @BindView(R.id.fragment_collection_progressBar)
    ProgressBar progressBar;
    @BindView(R.id.fragment_collection_recyclerView)
    RecyclerView recyclerView;

    private List<Photo> photos = new ArrayList<>();
    private PhotosAdapter photosAdapter;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection, container, false);
        unbinder = ButterKnife.bind(this, view);
        //RecyclerView
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        photosAdapter = new PhotosAdapter(getActivity(), photos);
        recyclerView.setAdapter(photosAdapter);

        Bundle bundle = getArguments();
        int collectionId = bundle.getInt("collectionId");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
