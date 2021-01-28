package ru.pshulepov.dreamjob.service;

import ru.pshulepov.dreamjob.model.Candidate;
import ru.pshulepov.dreamjob.model.Post;

import java.util.Collection;

public interface Store {

    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Post findByPostId(int id);

    Candidate findByCandidateId(int id);

}
