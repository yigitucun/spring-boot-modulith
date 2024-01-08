package com.ali.modulith.post.business.abstracts;

import com.ali.modulith.post.dto.requests.AddPostRequest;
import com.ali.modulith.post.dto.requests.UpdatePostRequest;
import com.ali.modulith.post.projections.ListPostProjection;

import java.util.List;

public interface PostService {
    AddPostRequest add(AddPostRequest request);
    List<ListPostProjection> getAll();
    void delete(int id);
    ListPostProjection getById(int id);
    UpdatePostRequest update(UpdatePostRequest request);

}
