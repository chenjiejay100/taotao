package com.taotao.controller;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;

public class TestPageHelper {

	@Test
	public void testPageHelper() {
		//����һ��spring����
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//��spring�����л��Mapper�Ĵ������
		TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);
		//ִ�в�ѯ������ҳ
		TbItemExample example = new TbItemExample();
		//��ҳ����
		PageHelper.startPage(2, 10);
		List<TbItem> list = mapper.selectByExample(example);//���������������ǲ�ѯ����
		//ȡ��Ʒ�б�
		for (TbItem tbItem : list) {
			System.out.println(tbItem.getTitle());
		}
		//ȡ��ҳ��Ϣ
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		long total = pageInfo.getTotal();
		System.out.println("������Ʒ��"+ total);
		
	}
}

