package ru.netology.repository;

import ru.netology.model.Post;

import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Stub
public class PostRepository {
    private final ConcurrentHashMap<Long, Post> posts = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong();

    public PostRepository() {
        posts.put(1L, new Post(1, "First"));
        posts.put(2L, new Post(2, "Second"));
        posts.put(3L, new Post(3, "Third"));
        idCounter.getAndSet(posts.size());
    }

    public Collection<Post> all() {
        return posts.values();
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(posts.get(id));
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            idCounter.incrementAndGet();
            post.setId(idCounter.get());
            posts.put(idCounter.get(), post);
        } else {
            posts.put(post.getId(), post);
        }
        return post;
    }

    public void removeById(long id) {
        posts.remove(id);
    }
}
