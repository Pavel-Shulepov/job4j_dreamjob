package ru.pshulepov.dreamjob.service;

import ru.pshulepov.dreamjob.model.Candidate;
import ru.pshulepov.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

    private static AtomicInteger POST_ID = new AtomicInteger(3);

    private static final Store INST = new Store();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(0, "Junior Java Job", "Новичек в программировании", LocalDateTime.now()));
        posts.put(2, new Post(1, "Middle Java Job", "Самостоятельный опытный программист", LocalDateTime.now()));
        posts.put(3, new Post(2, "Senior Java Job", "Наставник, тимлид, архитектор ПО", LocalDateTime.now()));
        candidates.put(1, new Candidate(0, "Junior Java Developer"));
        candidates.put(2, new Candidate(1, "Middle Java Developer"));
        candidates.put(3, new Candidate(2, "Senior Java Developer"));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        post.setId(POST_ID.incrementAndGet());
        posts.put(post.getId(), post);
    }

}
