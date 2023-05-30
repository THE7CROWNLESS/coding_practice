package project.StudentManageSystem;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ManageSystem {
    public static void main(String[] args) {

        //控制台页面
        boolean flag = true;
        while (flag){
            System.out.println("--------------------欢迎来到学生管理系统--------------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:退出系统");
            System.out.println("请输入你的选择：");
            Scanner scanner = new Scanner(System.in);
            String choose = scanner.next();
            List<Student> list = new ArrayList<>();

            if(choose.equals("1")) AddStudent(list);
            else if(choose.equals("2")) DeleteStudent(list);
            else if(choose.equals("3")) ModifyStudent(list);
            else if(choose.equals("4")) SearchStudent(list);
            else if(choose.equals("5")) {
                flag = false;
                System.out.println("退出系统");
                System.out.println("------------------------------------------------------");
            }

            else
                System.out.println("无效输入，请重新选择。");
        }
    }


    public static void AddStudent(List<Student> list){
        while (true) {
            System.out.println("----------添加学生----------");
            Student s = new Student();
            Scanner sc = new Scanner(System.in);

            while (true){
                System.out.println("请输入学生id（需唯一）:");
                String id = sc.next();
                if(containsID(list,id)){
                    System.out.println("该学生id已存在，请重新输入");
                    continue;
                }else {
                    break;
                }
            }

            System.out.println("请输入学生姓名:");
            s.setName(sc.next());
            System.out.println("请输入学生年龄:");
            s.setAge(sc.nextInt());
            System.out.println("请输入学生地址:");
            s.setAddress(sc.next());

            list.add(s);
            System.out.println("id\t\t\tname\t\tage\t\taddress");
            System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
            System.out.println("该学生添加成功");
            System.out.println("1:继续添加学生\n其他:退出添加，返回主页面");
            Scanner sc_1 = new Scanner(System.in);
            if(sc_1.next().equals("1")){
                continue;
            }else {
                break;
            }
            }
    }

    public static void DeleteStudent(List<Student> list){

    }

    public static void ModifyStudent(List<Student> list){

    }

    public static void SearchStudent(List<Student> list){

    }

    public static boolean containsID(List<Student> list, String id){

        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            String sid = student.getId();
            if(sid.equals(id)){
                return true;
            }
        }
        return false;
    }

}
