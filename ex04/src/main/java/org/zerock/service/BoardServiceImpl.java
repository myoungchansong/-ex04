package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class BoardServiceImpl implements BoardService{

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register............." + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(int bno) {
		
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify....................");	
		
		return mapper.update(board) == 1;
		
	}

	@Override
	public boolean remove(int bno) {
		
		log.info("remove................");
		
		return mapper.delete(bno) == 1;
	}

/*	@Override
	public List<BoardVO> getList() {
		
		log.info("getList.................");
		
		return mapper.getList();
	}
*/
	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		log.info("get List witg criteria: "+ cri);
		
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get Total Count");
		
		return mapper.gettotalCount(cri);
		
	}


}
