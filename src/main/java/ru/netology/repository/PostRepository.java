package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Stub
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();
    private int postCounter;

    public PostRepository() {
        posts.addAll(List.of(
                new Post(1, "First"),
                new Post(2, "Second"),
                new Post(3, "Third"),
                new Post(4, "Fourth"),
                new Post(5, "Fifth"),
                new Post(6, "Sixth"),
                new Post(7, "Seventh"),
                new Post(8, "Eighth"),
                new Post(9, "Ninth"),
                new Post(10, "Tenth"),
                new Post(11, "Eleventh")
        ));
        postCounter = posts.size();
    }

    public List<Post> all() {
        return posts;
    }

    public Optional<Post> getById(long id) {
        return posts.stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public Post save(Post post) {
        Optional<Post> postSearch = posts.stream()
                .filter(x -> x.getId() == post.getId())
                .findFirst();
        if (postSearch.isEmpty() || post.getId() == 0) {
            post.setId(++postCounter);
            posts.add(post);
        }
        return post;
    }

    public void removeById(long id) {
        posts.removeIf(post -> post.getId() == id);
    }
}
