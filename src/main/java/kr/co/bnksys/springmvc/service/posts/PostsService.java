package kr.co.bnksys.springmvc.service.posts;

import kr.co.bnksys.springmvc.domain.posts.Posts;
import kr.co.bnksys.springmvc.domain.posts.PostsRepository;
import kr.co.bnksys.springmvc.web.dto.PostsResponseDto;
import kr.co.bnksys.springmvc.web.dto.PostsSaveRequestDto;
import kr.co.bnksys.springmvc.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id=" + id));
        posts.update(dto.getTitle(), dto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }
}
