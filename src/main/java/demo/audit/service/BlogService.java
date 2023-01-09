package demo.audit.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import demo.audit.entity.Category;
import demo.audit.entity.CategoryRepository;
import demo.audit.entity.Post;
import demo.audit.entity.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogService {

    private final PostRepository postRepository;

    private final CategoryRepository categoryRepository;

    public Boolean test() {
        // Category category = new Category();
        // category.setCategoryName("lesson");
        // categoryRepository.save(category);

        var category = categoryRepository.findById(1).orElse(null);
        if (category != null) {
            Post post = new Post();
            post.setCategory(category);
            post.setPostContent("Deneme");
            post.setPostTitle("testTitle");
            postRepository.save(post);
        }
        return true;
    }

    public Boolean test1(String name) {
        Category category = new Category();
        category.setCategoryName(name);
        categoryRepository.save(category);
        return true;
    }

    public Boolean delete(Integer postId) {
        postRepository.deleteById(postId);
        return true;
    }

    public Boolean update(Integer postId) {
        var category = categoryRepository.findById(1).orElse(null);
        var post = postRepository.findById(postId).orElse(new Post());
        post.setCategory(category);
        post.setPostTitle("updatesssd");
        postRepository.save(post);
        return true;
    }

    public Boolean revision() {
        var revision = postRepository.findRevision(12, 14).orElse(null);
        if (Objects.nonNull(revision)) {
            log.info("{}", revision);
        }
        return true;
    }
}
