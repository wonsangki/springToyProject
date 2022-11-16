package com.study.springstudy.service.board;

import com.study.springstudy.entity.board.Board;
import com.study.springstudy.entity.board.Post;
import com.study.springstudy.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    public Optional<Integer> getPostCountInBoard(Long boardId){
        return boardRepository.findById(boardId)
                .map(Board::getPostList)
                .map(List::size)
                .or(() -> Optional.of(0));
    }



    public void addNewBoard(Board board){
        boardRepository.save(board);
    }

    public void modifyBoardInfo(Board board){
        boardRepository.save(board);
    }

    public void removeBoard(Long boardId){
        boardRepository.deleteById(boardId);
    }
}
