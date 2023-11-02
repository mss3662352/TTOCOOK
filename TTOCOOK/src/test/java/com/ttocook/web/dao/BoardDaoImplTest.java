package com.ttocook.web.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ttocook.web.dao.BoardDao;
import com.ttocook.web.domain.BoardDto;
import com.ttocook.web.domain.FrBoardDto;
import com.ttocook.web.domain.RecipeDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDaoImplTest {
	
	@Autowired
	BoardDao boardDao;
	
	@Autowired
	FrBoardDao frboardDao;
	
	@Autowired
	RecipeDao recipeDao;
	@Test
	public void insertTestData() throws Exception{
//		boardDao.deleteAll();
		for(int i =1; i<50; i++) {
			BoardDto boardDto = new BoardDto("ckbtitle " + i, "no ckbcon", "green");
			boardDao.insert(boardDto);
		}
	}
	@Test
	public void insertTestDataFr() throws Exception{
//		frboardDao.deleteAll();
		for(int i =1; i<50; i++) {
			FrBoardDto frboardDto = new FrBoardDto("frbtitle " + i, "no frbcon", "green");
			frboardDao.insert(frboardDto);
		}
	}
	@Test
	public void recipe() throws Exception{
		for(int i =1; i<3; i++) {
			RecipeDto recipeDto = new RecipeDto("상창", "rctitle "+ i, "맛있는 고기", "beef", "sub1", "sub2", "sub3", "sub4");
			recipeDao.insert(recipeDto);
		}
	}
	@Test
	public void selectTest() throws Exception{
		boardDao.deleteAll();
		assertTrue(boardDao.count() == 0);
		
		BoardDto boardDto = new BoardDto("no ckbtitle", "no ckbcon", "no ckbwriter");
		assertTrue(boardDao.insert(boardDto)==1);
		
		Integer ckbno = boardDao.selectAll().get(0).getCkbno();
		boardDto.setCkbno(ckbno);
		BoardDto boardDto2 = boardDao.select(ckbno);
		assertTrue(boardDto.equals(boardDto2));
	}
	
	@Test
    public void countTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no ckbtitle", "no ckbbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==2);
    }

    @Test
    public void testi() throws Exception{
        BoardDto dto = new BoardDto("a","b","c");
        boardDao.insert(dto);

    }

    @Test
    public void insertTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no ckbtitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);

        boardDto = new BoardDto("no ckbtitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==2);

        boardDao.deleteAll();
        boardDto = new BoardDto("no ckbtitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);
    }
    
    @Test
    public void updateTest() throws Exception {
        boardDao.deleteAll();
        BoardDto boardDto = new BoardDto("no ckbtitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);

        Integer ckbno = boardDao.selectAll().get(0).getCkbno();
        System.out.println("ckbno = " + ckbno);
        boardDto.setCkbno(ckbno);
        boardDto.setCkbtitle("yes cktitle");
        assertTrue(boardDao.update(boardDto)==1);

        BoardDto boardDto2 = boardDao.select(ckbno);
        assertTrue(boardDto.equals(boardDto2));
    }
    
    @Test
    public void deleteTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no ckbtitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        Integer ckbno = boardDao.selectAll().get(0).getCkbno();
        assertTrue(boardDao.delete(ckbno, boardDto.getCkbwriter())==1);
        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        ckbno = boardDao.selectAll().get(0).getCkbno();
//        assertTrue(boardDao.delete(ckbno, boardDto.getCkbwriter()+"222")==0);
//        assertTrue(boardDao.count()==1);
//
//        assertTrue(boardDao.delete(ckbno, boardDto.getCkbwriter())==1);
//        assertTrue(boardDao.count()==0);
//
//        assertTrue(boardDao.insert(boardDto)==1);
//        ckbno = boardDao.selectAll().get(0).getCkbno();
//        assertTrue(boardDao.delete(ckbno+1, boardDto.getCkbwriter())==0);
//        assertTrue(boardDao.count()==1);
    }
    
    @Test
    public void deleteAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no cktitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.deleteAll()==1);
        assertTrue(boardDao.count()==0);

        boardDto = new BoardDto("no cktitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.deleteAll()==2);
        assertTrue(boardDao.count()==0);
    }

    

    

    @Test
    public void selectAllTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        List<BoardDto> list = boardDao.selectAll();
        assertTrue(list.size() == 0);

        BoardDto boardDto = new BoardDto("no cktitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);

        list = boardDao.selectAll();
        assertTrue(list.size() == 1);

        assertTrue(boardDao.insert(boardDto)==1);
        list = boardDao.selectAll();
        assertTrue(list.size() == 2);
    }


    @Test
    public void increaseViewCntTest() throws Exception {
        boardDao.deleteAll();
        assertTrue(boardDao.count()==0);

        BoardDto boardDto = new BoardDto("no cktitle", "no ckbcon", "green");
        assertTrue(boardDao.insert(boardDto)==1);
        assertTrue(boardDao.count()==1);

        Integer ckbno = boardDao.selectAll().get(0).getCkbno();
        assertTrue(boardDao.increaseViewCnt(ckbno)==1);

        boardDto = boardDao.select(ckbno);
        assertTrue(boardDto!=null);
        assertTrue(boardDto.getCkview_cnt() == 1);

        assertTrue(boardDao.increaseViewCnt(ckbno)==1);
        
    }

}
