package project.StudentManageSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ManageSystem {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(); //放在循环内部，每次都会将数据覆盖为空。
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


            if(choose.equals("1")) AddStudent(list);
            else if(choose.equals("2")) DeleteStudent(list);
            else if(choose.equals("3")) ModifyStudent(list);
            else if(choose.equals("4")) SearchStudent(list,false);
            else if(choose.equals("5")) {
                flag = false;
                System.out.println("退出系统");
                System.out.println("------------------------------------------------------");
            }

            else
                System.out.println("无效输入，请重新选择。");
        }
    }

    //添加学生
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
                    s.setId(id);
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
            System.out.print("该学生添加成功。");
            System.out.println("1:继续添加学生\t其他:退出添加，返回主页面");
            Scanner sc_1 = new Scanner(System.in);
            if(sc_1.next().equals("1")){
                continue;
            }else {
                break;
            }
            }
       // System.out.println(list.size());
    }

    //删除学生
    public static void DeleteStudent(List<Student> list){
        while (true)
        {
            System.out.println("----------删除学生----------");
            int index = SearchStudent(list,true);
            if (index != -1) {
                System.out.println("1:确认删除\t其他：取消删除");
                Scanner scanner = new Scanner(System.in);
                if(scanner.next().equals("1")){
                    list.remove(index);
                    System.out.println("删除成功");
                }else {
                    System.out.println("取消删除");
                }
            } else {
                System.out.println("该学生不存在，删除失败");
            }
            System.out.println("1:继续删除学生\t其他:退出添加，返回主页面");
            Scanner sc_1 = new Scanner(System.in);
            if(sc_1.next().equals("1")){
                continue;
            }else {
                break;
            }
        }

    }

    //修改学生
    public static void ModifyStudent(List<Student> list){
        System.out.println("----------修改学生----------");
        while (true)
        {   Scanner sc = new Scanner(System.in);

            int index = SearchStudent(list, true);
            if (index != -1){
                Student s = list.get(index);
                System.out.println("请输入学生姓名:");
                s.setName(sc.next());
                System.out.println("请输入学生年龄:");
                s.setAge(sc.nextInt());
                System.out.println("请输入学生地址:");
                s.setAddress(sc.next());

                System.out.println("修改成功!");
                System.out.println("id\t\t\tname\t\tage\t\taddress");
                System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());

            }
            System.out.println("1:继续修改学生\t其他:退出添加，返回主页面");
            if(sc.next().equals("1")){
                continue;
            }else {
                break;
            }
        }

    }

    //搜索学生
    public static int SearchStudent(List<Student> list,boolean other){
        System.out.println(list.size());
        int index = -1;
        while (true)
        {
            System.out.println("请输入学生序号：");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            for (int i = 0; i < list.size(); i++) {
                Student s = list.get(i);
                if (s.getId().equals(id)) {
                    System.out.println("查询结果：");
                    System.out.println("id\t\t\tname\t\tage\t\taddress");
                    System.out.println(s.getId() + "\t\t" + s.getName() + "\t\t" + s.getAge() + "\t\t" + s.getAddress());
                    index = i;
                    if(other){
                        return index;
                    }
                }
            }
            if(index == -1){
                System.out.println("查询失败，没有该学生序号信息。");
                if(other){
                    return index;
                }
            }
            System.out.println("1:继续查询\t其他:退出查询,返回主页面。");
            if(scanner.next().equals("1")){
                continue;
            }else {
                break;
            }
        }
        return index;

    }

    //id唯一性检查
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
