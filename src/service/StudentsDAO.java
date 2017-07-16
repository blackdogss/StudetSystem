package service;

import java.util.List;

import entity.Students;

//ѧ��ҵ���߼��ӿ�
public interface StudentsDAO {

	//��ѯѧ������
	public List<Students> queryAllStudents();
	
	//g����ѧ����Ų�ѯѧ������
	public Students queryStudentsById(String sid);
	
	//���ѧ������
	public boolean addStudents(Students students);
	
	//�޸�ѧ������
	public boolean updateStudents(Students students);
	
	//ɾ��ѧ������
	public boolean deleteStudents(String sid);
}
