package ru.pshulepov.dreamjob.service;

import ru.pshulepov.dreamjob.model.Candidate;
import ru.pshulepov.dreamjob.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore {

    private static AtomicInteger POST_ID = new AtomicInteger(3);
    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(3);

    private static MemStore INST = new MemStore();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Новичек в программировании", LocalDateTime.now()));
        posts.put(2, new Post(2, "Middle Java Job", "Самостоятельный опытный программист", LocalDateTime.now()));
        posts.put(3, new Post(3, "Senior Java Job", "Наставник, тимлид, архитектор ПО", LocalDateTime.now()));
        candidates.put(1, new Candidate(1, "Иван Иваныч", "Иванов", 1975, 10, "+79220012201"));
        candidates.put(2, new Candidate(2, "Петр петрович", "Петров", 1991, 3, "+79220010102"));
        candidates.put(3, new Candidate(3, "Павел Анатольевич", "Шулепов", 1984, 6, "+79220091599"));
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Post findByIdPost(int id) {
        return posts.get(id);
    }

    public Candidate findByIdCandidate(int id) {
        return candidates.get(id);
    }

}
