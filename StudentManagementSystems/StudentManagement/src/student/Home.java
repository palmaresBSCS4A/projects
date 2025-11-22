/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package student;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import javax.swing.JComboBox;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JTextField;

/**
 *
 * @author MARY ANGEL
 */
public class Home extends javax.swing.JFrame {
   
    private StudentThreader Studentthreader;
    private CourseThreader courseThreader;
    private GradeThreader gradeThreader;
    private Client client;
    private final Map<String, String[]> courseMap = new HashMap<>();



    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        initializeCourseMap();
        Studentthreader = new StudentThreader();
        courseThreader  = new CourseThreader();
        gradeThreader = new GradeThreader();
        client = new Client("127.0.0.1", 12345);

        Studentthreader.loadTableData((DefaultTableModel) spTable.getModel());   
    }
    
    private void initializeCourseMap() {
    // === BSCS Courses ===
    courseMap.put("BSCS-1st Year-1st Semester", new String[]{
        "Introduction to Computing", "Computer Programming 1", "Discrete Mathematics", "Calculus 1", "Purposive Communication"
    });
    courseMap.put("BSCS-1st Year-2nd Semester", new String[]{
        "Data Structures and Algorithms", "Computer Programming 2", "Calculus 2", "Ethics", "Understanding the Self"
    });
    courseMap.put("BSCS-2nd Year-1st Semester", new String[]{
        "Operating Systems", "Computer Organization", "Linear Algebra", "Science, Technology and Society", "Physical Education 3"
    });
    courseMap.put("BSCS-2nd Year-2nd Semester", new String[]{
        "Database Systems", "Software Engineering", "Automata and Formal Languages", "PE 4", "Art Appreciation"
    });
    courseMap.put("BSCS-3rd Year-1st Semester", new String[]{
        "Design and Analysis of Algorithms", "Web Development", "CS Elective 1", "Professional Issues in IT", "Life and Works of Rizal"
    });
    courseMap.put("BSCS-3rd Year-2nd Semester", new String[]{
        "Artificial Intelligence", "CS Elective 2", "Technopreneurship", "Internship Preparation", "Readings in Philippine History"
    });
    courseMap.put("BSCS-4th Year-1st Semester", new String[]{
        "Capstone Project 1", "CS Elective 3", "Mobile App Development", "IT Laws and Ethics", "Environmental Science"
    });
    courseMap.put("BSCS-4th Year-2nd Semester", new String[]{
        "Capstone Project 2", "Internship / OJT", "CS Seminar", "Career Preparation", "Free Elective"
    });

    // === BSIS Courses ===
    courseMap.put("BSIS-1st Year-1st Semester", new String[]{
        "Introduction to Information Systems", "Basic Programming", "Communication Skills", "Business Mathematics", "Fundamentals of Accounting"
    });
    courseMap.put("BSIS-1st Year-2nd Semester", new String[]{
        "Web Development 1", "Database Management Systems", "Statistics", "Ethics", "Understanding the Self"
    });
    courseMap.put("BSIS-2nd Year-1st Semester", new String[]{
        "Systems Analysis and Design", "Human-Computer Interaction", "Data Management", "Science, Technology and Society", "Physical Education 3"
    });
    courseMap.put("BSIS-2nd Year-2nd Semester", new String[]{
        "Information Management", "Object-Oriented Programming", "Management Information Systems", "PE 4", "Art Appreciation"
    });
    courseMap.put("BSIS-3rd Year-1st Semester", new String[]{
        "IT Project Management", "E-Commerce Systems", "Business Intelligence", "Professional Issues in IS", "Life and Works of Rizal"
    });
    courseMap.put("BSIS-3rd Year-2nd Semester", new String[]{
        "Enterprise Systems", "IS Strategy and Governance", "Technopreneurship", "IS Elective 1", "Readings in Philippine History"
    });
    courseMap.put("BSIS-4th Year-1st Semester", new String[]{
        "Capstone Project 1", "IS Elective 2", "IT Laws and Policies", "IS Seminar", "Environmental Science"
    });
    courseMap.put("BSIS-4th Year-2nd Semester", new String[]{
        "Capstone Project 2", "Internship / OJT", "IS Elective 3", "Career Development", "Free Elective"
    });

    // === BSIT Courses ===
    courseMap.put("BSIT-1st Year-1st Semester", new String[]{
        "IT Fundamentals", "Programming 1", "College Algebra", "English Communication 1", "Physical Education 1"
    });
    courseMap.put("BSIT-1st Year-2nd Semester", new String[]{
        "Web Systems and Technologies", "Object-Oriented Programming", "Networking Fundamentals", "PE 2", "NSTP 2"
    });
    courseMap.put("BSIT-2nd Year-1st Semester", new String[]{
        "Data Structures and Algorithms", "Operating Systems", "Discrete Mathematics", "Science, Technology and Society", "Physical Education 3"
    });
    courseMap.put("BSIT-2nd Year-2nd Semester", new String[]{
        "System Integration and Architecture", "Human-Computer Interaction", "Database Systems", "PE 4", "Art Appreciation"
    });
    courseMap.put("BSIT-3rd Year-1st Semester", new String[]{
        "Mobile App Development", "IT Elective 1", "Software Engineering", "Professional Issues in IT", "Life and Works of Rizal"
    });
    courseMap.put("BSIT-3rd Year-2nd Semester", new String[]{
        "Cybersecurity Fundamentals", "Technopreneurship", "IT Elective 2", "Capstone Project Planning", "Readings in Philippine History"
    });
    courseMap.put("BSIT-4th Year-1st Semester", new String[]{
        "Capstone Project 1", "IT Elective 3", "Cloud Computing", "IT Laws and Ethics", "Environmental Science"
    });
    courseMap.put("BSIT-4th Year-2nd Semester", new String[]{
        "Capstone Project 2", "Internship / OJT", "Seminar and Workshop", "Career Development", "Free Elective"
    });
}

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel13 = new javax.swing.JPanel();
        semesterJcombo1 = new javax.swing.JComboBox<>();
        course1JCombo1 = new javax.swing.JComboBox<>();
        course2JCombo1 = new javax.swing.JComboBox<>();
        course3JCombo1 = new javax.swing.JComboBox<>();
        course4JCombo1 = new javax.swing.JComboBox<>();
        course5JCombo1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        studentPANEL = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        spIDTF = new javax.swing.JTextField();
        spNameTF = new javax.swing.JTextField();
        spGender = new javax.swing.JComboBox<>();
        spAddressTF = new javax.swing.JTextField();
        spEmailTF = new javax.swing.JTextField();
        spPhoneNumberTF = new javax.swing.JTextField();
        spFatherNameTF = new javax.swing.JTextField();
        spMotherNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        spDateOfBirth = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        spYearSectionTF = new javax.swing.JTextField();
        spCourseTF = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        spSearchStudentTF = new javax.swing.JTextField();
        spSearchBTN = new javax.swing.JButton();
        spRefreshBTN = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        spTable = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        spUpdateBTN = new javax.swing.JButton();
        spDeleteBTN = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        spUndoBTN = new javax.swing.JButton();
        spSaveBTN = new javax.swing.JButton();
        coursePANEL = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        courseStudIDTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        semesterJcombo = new javax.swing.JComboBox<>();
        course1JCombo = new javax.swing.JComboBox<>();
        course2JCombo = new javax.swing.JComboBox<>();
        course3JCombo = new javax.swing.JComboBox<>();
        course4JCombo = new javax.swing.JComboBox<>();
        course5JCombo = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        courseAcadYearTF = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        CourseTF = new javax.swing.JTextField();
        YearSectionTF = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        courseSearchTF = new javax.swing.JTextField();
        courseSearchBTN = new javax.swing.JButton();
        courseRefreshBTN = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        courseSaveBTN = new javax.swing.JButton();
        dropCourseBTN = new javax.swing.JButton();
        courseDeleteBTN = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        gradesPANEL = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        gradeStudIDTF = new javax.swing.JTextField();
        courseNameTF1 = new javax.swing.JTextField();
        courseNameTF2 = new javax.swing.JTextField();
        courseNameTF3 = new javax.swing.JTextField();
        courseNameTF4 = new javax.swing.JTextField();
        courseNameTF5 = new javax.swing.JTextField();
        courseGradeTF1 = new javax.swing.JTextField();
        courseGradeTF2 = new javax.swing.JTextField();
        courseGradeTF3 = new javax.swing.JTextField();
        courseGradeTF4 = new javax.swing.JTextField();
        courseGradeTF5 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        gradeAcadYearTF = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        gradesemesterJcombo = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        gwaTF = new javax.swing.JTextField();
        gradeCoursesBTN = new javax.swing.JButton();
        gradeGWABTN = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        gradeTable = new javax.swing.JTable();
        gradeIDTF = new javax.swing.JTextField();
        gradeNameTF = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        gradeAYTF = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        gradeSearchBTN = new javax.swing.JButton();
        gwaTFDisplay = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        gradesemesterJcomboSearch = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        gradeSave = new javax.swing.JButton();
        gradeUpdate = new javax.swing.JButton();
        printRFBTN = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();

        jPanel13.setBackground(new java.awt.Color(0, 102, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        semesterJcombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        semesterJcombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        semesterJcombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterJcombo1ActionPerformed(evt);
            }
        });

        course1JCombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course1JCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course1JCombo1ActionPerformed(evt);
            }
        });

        course2JCombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course2JCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course2JCombo1ActionPerformed(evt);
            }
        });

        course3JCombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course3JCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course3JCombo1ActionPerformed(evt);
            }
        });

        course4JCombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course4JCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course4JCombo1ActionPerformed(evt);
            }
        });

        course5JCombo1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course5JCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course5JCombo1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Semester");

        jLabel26.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Course 1");

        jLabel27.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Course 2");

        jLabel38.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Course 3");

        jLabel39.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Course 4");

        jLabel40.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Course 5");

        jLabel41.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));

        jLabel43.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("3 UNITS");

        jLabel44.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("3 UNITS");

        jLabel45.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("3 UNITS");

        jLabel46.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("3 UNITS");

        jLabel47.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("3 UNITS");

        jLabel48.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Academic Year");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(443, 443, 443)
                        .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(semesterJcombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel13Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(course4JCombo1, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                            .addComponent(course3JCombo1, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                            .addComponent(course2JCombo1, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE)
                                            .addComponent(course1JCombo1, 0, 1, Short.MAX_VALUE)
                                            .addComponent(course5JCombo1, javax.swing.GroupLayout.Alignment.LEADING, 0, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel41)
                .addGap(120, 120, 120)
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semesterJcombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course1JCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course2JCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course3JCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(course4JCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39))
                    .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course5JCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 740));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 153, 22));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Console", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("COMPUTER DEPARTMENT STUDENT MANAGEMENT SYSTEMS");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(214, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(-2, 6, 1390, 64);

        tab.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N

        studentPANEL.setBackground(new java.awt.Color(0, 153, 22));
        studentPANEL.setMaximumSize(new java.awt.Dimension(1270, 700));
        studentPANEL.setMinimumSize(new java.awt.Dimension(1270, 700));
        studentPANEL.setPreferredSize(new java.awt.Dimension(1270, 700));

        jPanel4.setBackground(new java.awt.Color(0, 102, 0));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));
        jPanel4.setMaximumSize(new java.awt.Dimension(404, 530));
        jPanel4.setMinimumSize(new java.awt.Dimension(404, 530));

        spIDTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N

        spNameTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spNameTFActionPerformed(evt);
            }
        });

        spGender.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        spGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spGenderActionPerformed(evt);
            }
        });

        spAddressTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N

        spEmailTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spEmailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spEmailTFActionPerformed(evt);
            }
        });

        spPhoneNumberTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N

        spFatherNameTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spFatherNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spFatherNameTFActionPerformed(evt);
            }
        });

        spMotherNameTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student's ID");

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student's Name");

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Sex");

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date of Birth");

        jLabel6.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone Number");

        jLabel9.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Father's Name");

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mother's Name");

        jLabel11.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Year & Section");

        spYearSectionTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spYearSectionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spYearSectionTFActionPerformed(evt);
            }
        });

        spCourseTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spCourseTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spCourseTFActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Course");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(spGender, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spNameTF)
                    .addComponent(spIDTF)
                    .addComponent(spFatherNameTF)
                    .addComponent(spPhoneNumberTF)
                    .addComponent(spEmailTF)
                    .addComponent(spAddressTF)
                    .addComponent(spDateOfBirth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spYearSectionTF)
                    .addComponent(spCourseTF)
                    .addComponent(spMotherNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spCourseTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(spYearSectionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(spDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(spAddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spEmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(spPhoneNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spFatherNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spMotherNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(99, 99, 99))
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jPanel8.setBackground(new java.awt.Color(0, 153, 22));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jLabel12.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Search Student");

        spSearchStudentTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        spSearchStudentTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spSearchStudentTFActionPerformed(evt);
            }
        });

        spSearchBTN.setBackground(new java.awt.Color(0, 153, 22));
        spSearchBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spSearchBTN.setForeground(new java.awt.Color(255, 255, 255));
        spSearchBTN.setText("Search");
        spSearchBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spSearchBTN.setPreferredSize(new java.awt.Dimension(151, 98));
        spSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spSearchBTNActionPerformed(evt);
            }
        });

        spRefreshBTN.setBackground(new java.awt.Color(0, 153, 22));
        spRefreshBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spRefreshBTN.setForeground(new java.awt.Color(255, 255, 255));
        spRefreshBTN.setText("Refresh");
        spRefreshBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spRefreshBTN.setPreferredSize(new java.awt.Dimension(151, 98));
        spRefreshBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spRefreshBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spSearchStudentTF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spRefreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(spSearchStudentTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spRefreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 102, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        spTable.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        spTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Course", "Year & Section", "Sex", "Date of Birth", "Address", "Email", "Phone Number", "Father's Name", "Mother's Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(spTable);
        if (spTable.getColumnModel().getColumnCount() > 0) {
            spTable.getColumnModel().getColumn(10).setResizable(false);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(0, 102, 0));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        spUpdateBTN.setBackground(new java.awt.Color(0, 153, 22));
        spUpdateBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spUpdateBTN.setForeground(new java.awt.Color(255, 255, 255));
        spUpdateBTN.setText("Update");
        spUpdateBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spUpdateBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spUpdateBTNActionPerformed(evt);
            }
        });

        spDeleteBTN.setBackground(new java.awt.Color(0, 153, 22));
        spDeleteBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spDeleteBTN.setForeground(new java.awt.Color(255, 255, 255));
        spDeleteBTN.setText("Delete");
        spDeleteBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spDeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spDeleteBTNActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 153, 22));
        logout.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setText("Logout");
        logout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        spUndoBTN.setBackground(new java.awt.Color(0, 153, 22));
        spUndoBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spUndoBTN.setForeground(new java.awt.Color(255, 255, 255));
        spUndoBTN.setText("Undo");
        spUndoBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spUndoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spUndoBTNActionPerformed(evt);
            }
        });

        spSaveBTN.setBackground(new java.awt.Color(0, 153, 22));
        spSaveBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        spSaveBTN.setForeground(new java.awt.Color(255, 255, 255));
        spSaveBTN.setText("Save");
        spSaveBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        spSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spSaveBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(spSaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spUndoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spUpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(spDeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spUpdateBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spUndoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spSaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout studentPANELLayout = new javax.swing.GroupLayout(studentPANEL);
        studentPANEL.setLayout(studentPANELLayout);
        studentPANELLayout.setHorizontalGroup(
            studentPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPANELLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        studentPANELLayout.setVerticalGroup(
            studentPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studentPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(studentPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab.addTab("Student", studentPANEL);

        coursePANEL.setBackground(new java.awt.Color(0, 153, 22));

        jPanel12.setBackground(new java.awt.Color(0, 102, 0));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        courseStudIDTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseStudIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseStudIDTFActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student's ID");

        semesterJcombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        semesterJcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        semesterJcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterJcomboActionPerformed(evt);
            }
        });

        course1JCombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course1JCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course1JComboActionPerformed(evt);
            }
        });

        course2JCombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course2JCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course2JComboActionPerformed(evt);
            }
        });

        course3JCombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course3JCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course3JComboActionPerformed(evt);
            }
        });

        course4JCombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course4JCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course4JComboActionPerformed(evt);
            }
        });

        course5JCombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        course5JCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course5JComboActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Semester");

        jLabel18.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Course 1");

        jLabel19.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Course 2");

        jLabel20.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Course 3");

        jLabel21.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Course 4");

        jLabel23.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Course 5");

        jLabel28.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));

        jLabel29.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Academic Year");

        courseAcadYearTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseAcadYearTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseAcadYearTFActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("3 UNITS");

        jLabel33.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("3 UNITS");

        jLabel34.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("3 UNITS");

        jLabel35.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("3 UNITS");

        jLabel36.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("3 UNITS");

        jLabel37.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Course");

        CourseTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        CourseTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CourseTFActionPerformed(evt);
            }
        });

        YearSectionTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        YearSectionTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YearSectionTFActionPerformed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Year and Section");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseStudIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 16, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(course3JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(course2JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(course4JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(course5JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(courseAcadYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CourseTF, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(YearSectionTF, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(semesterJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(course1JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(courseStudIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(courseAcadYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CourseTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(YearSectionTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(semesterJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course1JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course2JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(course3JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course4JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course5JCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(0, 102, 0));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jPanel16.setBackground(new java.awt.Color(0, 153, 22));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jLabel25.setFont(new java.awt.Font("Lucida Bright", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Search Record");

        courseSearchTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseSearchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearchTFActionPerformed(evt);
            }
        });

        courseSearchBTN.setBackground(new java.awt.Color(0, 153, 22));
        courseSearchBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        courseSearchBTN.setForeground(new java.awt.Color(255, 255, 255));
        courseSearchBTN.setText("Search");
        courseSearchBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        courseSearchBTN.setPreferredSize(new java.awt.Dimension(151, 98));
        courseSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearchBTNActionPerformed(evt);
            }
        });

        courseRefreshBTN.setBackground(new java.awt.Color(0, 153, 22));
        courseRefreshBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        courseRefreshBTN.setForeground(new java.awt.Color(255, 255, 255));
        courseRefreshBTN.setText("Refresh");
        courseRefreshBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        courseRefreshBTN.setPreferredSize(new java.awt.Dimension(151, 98));
        courseRefreshBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRefreshBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseSearchTF, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(courseSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(courseRefreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(courseSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseRefreshBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(0, 102, 0));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        courseTable.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Academic Year", "Semester", "Course 1", "Course 2", "Course 3", "Course 4", "Course 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(courseTable);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBackground(new java.awt.Color(0, 102, 0));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        courseSaveBTN.setBackground(new java.awt.Color(0, 153, 22));
        courseSaveBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        courseSaveBTN.setForeground(new java.awt.Color(255, 255, 255));
        courseSaveBTN.setText("Save");
        courseSaveBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        courseSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSaveBTNActionPerformed(evt);
            }
        });

        dropCourseBTN.setBackground(new java.awt.Color(0, 153, 22));
        dropCourseBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        dropCourseBTN.setForeground(new java.awt.Color(255, 255, 255));
        dropCourseBTN.setText("Drop");
        dropCourseBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        dropCourseBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropCourseBTNActionPerformed(evt);
            }
        });

        courseDeleteBTN.setBackground(new java.awt.Color(0, 153, 22));
        courseDeleteBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        courseDeleteBTN.setForeground(new java.awt.Color(255, 255, 255));
        courseDeleteBTN.setText("Delete");
        courseDeleteBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        courseDeleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseDeleteBTNActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 153, 22));
        jButton18.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Logout");
        jButton18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(courseSaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dropCourseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(courseDeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseSaveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropCourseBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseDeleteBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout coursePANELLayout = new javax.swing.GroupLayout(coursePANEL);
        coursePANEL.setLayout(coursePANELLayout);
        coursePANELLayout.setHorizontalGroup(
            coursePANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursePANELLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132))
        );
        coursePANELLayout.setVerticalGroup(
            coursePANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(coursePANELLayout.createSequentialGroup()
                .addGroup(coursePANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, coursePANELLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab.addTab("Course", coursePANEL);

        gradesPANEL.setBackground(new java.awt.Color(0, 153, 22));

        jPanel20.setBackground(new java.awt.Color(0, 102, 0));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jLabel50.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Student's ID");

        jLabel52.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Course 1");

        jLabel53.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Course 2");

        jLabel54.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Course 3");

        jLabel55.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Course 4");

        jLabel56.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("Course 5");

        gradeStudIDTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradeStudIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeStudIDTFActionPerformed(evt);
            }
        });

        courseNameTF1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseNameTF1.setEnabled(false);
        courseNameTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameTF1ActionPerformed(evt);
            }
        });

        courseNameTF2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseNameTF2.setEnabled(false);
        courseNameTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameTF2ActionPerformed(evt);
            }
        });

        courseNameTF3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseNameTF3.setEnabled(false);
        courseNameTF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameTF3ActionPerformed(evt);
            }
        });

        courseNameTF4.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseNameTF4.setEnabled(false);
        courseNameTF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameTF4ActionPerformed(evt);
            }
        });

        courseNameTF5.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseNameTF5.setEnabled(false);
        courseNameTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseNameTF5ActionPerformed(evt);
            }
        });

        courseGradeTF1.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseGradeTF1.setText("0.0");
        courseGradeTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseGradeTF1ActionPerformed(evt);
            }
        });

        courseGradeTF2.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseGradeTF2.setText("0.0");
        courseGradeTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseGradeTF2ActionPerformed(evt);
            }
        });

        courseGradeTF3.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseGradeTF3.setText("0.0");
        courseGradeTF3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseGradeTF3ActionPerformed(evt);
            }
        });

        courseGradeTF4.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseGradeTF4.setText("0.0");
        courseGradeTF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseGradeTF4ActionPerformed(evt);
            }
        });

        courseGradeTF5.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        courseGradeTF5.setText("0.0");
        courseGradeTF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseGradeTF5ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Academic Year");

        gradeAcadYearTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradeAcadYearTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeAcadYearTFActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Semester");

        gradesemesterJcombo.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradesemesterJcombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        gradesemesterJcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradesemesterJcomboActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("GWA: ");

        gwaTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gwaTF.setText("0.0");
        gwaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gwaTFActionPerformed(evt);
            }
        });

        gradeCoursesBTN.setBackground(new java.awt.Color(0, 153, 22));
        gradeCoursesBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        gradeCoursesBTN.setForeground(new java.awt.Color(255, 255, 255));
        gradeCoursesBTN.setText("Load Courses");
        gradeCoursesBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gradeCoursesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeCoursesBTNActionPerformed(evt);
            }
        });

        gradeGWABTN.setBackground(new java.awt.Color(0, 153, 22));
        gradeGWABTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        gradeGWABTN.setForeground(new java.awt.Color(255, 255, 255));
        gradeGWABTN.setText("Calculate GWA");
        gradeGWABTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gradeGWABTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeGWABTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(gradeStudIDTF)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gradesemesterJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gradeAcadYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(courseNameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseGradeTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(courseNameTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseGradeTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(courseNameTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseGradeTF3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(courseNameTF4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseGradeTF4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(courseNameTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(courseGradeTF5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gradeCoursesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gradeGWABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gwaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeStudIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(gradeAcadYearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(gradesemesterJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(gradeCoursesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(courseNameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseGradeTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(courseNameTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseGradeTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54)
                    .addComponent(courseNameTF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseGradeTF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(courseNameTF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseGradeTF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(courseNameTF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseGradeTF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(gradeGWABTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(gwaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBackground(new java.awt.Color(0, 102, 0));
        jPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        jPanel25.setBackground(new java.awt.Color(0, 102, 0));
        jPanel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        gradeTable.setFont(new java.awt.Font("Lucida Bright", 0, 12)); // NOI18N
        gradeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Course ", "Grade", "Units"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeTable.setEnabled(false);
        gradeTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                gradeTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane6.setViewportView(gradeTable);

        gradeIDTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradeIDTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeIDTFActionPerformed(evt);
            }
        });

        gradeNameTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradeNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeNameTFActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Student ID");

        jLabel59.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Student Name");

        jLabel60.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Academic Year");

        gradeAYTF.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradeAYTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeAYTFActionPerformed(evt);
            }
        });

        jLabel61.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("Semester");

        gradeSearchBTN.setBackground(new java.awt.Color(0, 153, 22));
        gradeSearchBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        gradeSearchBTN.setForeground(new java.awt.Color(255, 255, 255));
        gradeSearchBTN.setText("Search");
        gradeSearchBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gradeSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeSearchBTNActionPerformed(evt);
            }
        });

        gwaTFDisplay.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gwaTFDisplay.setText("0.0");
        gwaTFDisplay.setEnabled(false);
        gwaTFDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gwaTFDisplayActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("GWA: ");

        gradesemesterJcomboSearch.setFont(new java.awt.Font("Lucida Bright", 0, 14)); // NOI18N
        gradesemesterJcomboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st Semester", "2nd Semester" }));
        gradesemesterJcomboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradesemesterJcomboSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(gradeIDTF, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(gradeNameTF)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradeAYTF)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(gwaTFDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(gradesemesterJcomboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel25Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(gradeSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradeIDTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradeNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel60)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradeAYTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gradesemesterJcomboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(gradeSearchBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gwaTFDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62)))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel26.setBackground(new java.awt.Color(0, 102, 0));
        jPanel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0), 4));

        gradeSave.setBackground(new java.awt.Color(0, 153, 22));
        gradeSave.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        gradeSave.setForeground(new java.awt.Color(255, 255, 255));
        gradeSave.setText("Save");
        gradeSave.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gradeSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeSaveActionPerformed(evt);
            }
        });

        gradeUpdate.setBackground(new java.awt.Color(0, 153, 22));
        gradeUpdate.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        gradeUpdate.setForeground(new java.awt.Color(255, 255, 255));
        gradeUpdate.setText("Update");
        gradeUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gradeUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeUpdateActionPerformed(evt);
            }
        });

        printRFBTN.setBackground(new java.awt.Color(0, 153, 22));
        printRFBTN.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        printRFBTN.setForeground(new java.awt.Color(255, 255, 255));
        printRFBTN.setText("Print RF");
        printRFBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        printRFBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printRFBTNActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(0, 153, 22));
        jButton27.setFont(new java.awt.Font("Lucida Bright", 1, 16)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setText("Logout");
        jButton27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(gradeSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gradeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(printRFBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gradeSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gradeUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printRFBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout gradesPANELLayout = new javax.swing.GroupLayout(gradesPANEL);
        gradesPANEL.setLayout(gradesPANELLayout);
        gradesPANELLayout.setHorizontalGroup(
            gradesPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradesPANELLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        gradesPANELLayout.setVerticalGroup(
            gradesPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradesPANELLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradesPANELLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab.addTab("Grades", gradesPANEL);

        jPanel1.add(tab);
        tab.setBounds(10, 80, 1270, 610);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1280, 690);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void spEmailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spEmailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spEmailTFActionPerformed

    private void spGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spGenderActionPerformed

    private void spNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spNameTFActionPerformed

    private void spSearchStudentTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spSearchStudentTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spSearchStudentTFActionPerformed

    private void spRefreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spRefreshBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) spTable.getModel();
        Studentthreader.loadTableData(model);
    }//GEN-LAST:event_spRefreshBTNActionPerformed

    private void courseSearchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSearchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseSearchTFActionPerformed

    private void courseRefreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRefreshBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        courseThreader.loadTableData(model);
    }//GEN-LAST:event_courseRefreshBTNActionPerformed

    private void gradeStudIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeStudIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeStudIDTFActionPerformed

    private void courseNameTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTF1ActionPerformed

    private void courseNameTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTF2ActionPerformed

    private void courseNameTF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTF3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTF3ActionPerformed

    private void courseNameTF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTF4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTF4ActionPerformed

    private void courseNameTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseNameTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseNameTF5ActionPerformed

    private void courseGradeTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseGradeTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseGradeTF1ActionPerformed

    private void courseGradeTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseGradeTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseGradeTF2ActionPerformed

    private void courseGradeTF3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseGradeTF3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseGradeTF3ActionPerformed

    private void courseGradeTF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseGradeTF4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseGradeTF4ActionPerformed

    private void courseGradeTF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseGradeTF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseGradeTF5ActionPerformed

    private void spSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spSaveBTNActionPerformed
        try {
        String studentId = spIDTF.getText();

        if (studentId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Student ID cannot be empty.");
            return;
        }

        client.sendCommand("ADD_STUDENT");
        client.sendCommand(studentId);

        String serverResponse = client.readResponse();

        if (serverResponse.equals("Student saved successfully!")) {
            StudentThreader studentThreader = new StudentThreader();
            studentThreader.saveStudent(
                spIDTF, spNameTF, spCourseTF, spYearSectionTF,
                spGender, spDateOfBirth, spAddressTF, spEmailTF,
                spPhoneNumberTF, spFatherNameTF, spMotherNameTF
            );

            studentThreader.loadTableData((DefaultTableModel) spTable.getModel());
            
            spIDTF.setText("");
            spNameTF.setText("");
            spCourseTF.setText("");
            spYearSectionTF.setText("");
            spAddressTF.setText("");
            spEmailTF.setText("");
            spPhoneNumberTF.setText("");
            spFatherNameTF.setText("");
            spMotherNameTF.setText("");

            spGender.setSelectedIndex(0); 

            spDateOfBirth.setDate(null);
        } else {
            JOptionPane.showMessageDialog(this, "Error adding student: " + serverResponse);
        }

    } catch (IOException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Unexpected error: " + ex.getMessage());
    }
    }//GEN-LAST:event_spSaveBTNActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
          int a = JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "COMPUTER DEPARTMENT", JOptionPane.YES_NO_OPTION);
    
    if (a == JOptionPane.YES_OPTION) {
        try {
            client.close();  
             System.out.println("Client Disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.dispose();     
        System.exit(0);      
    }
    }//GEN-LAST:event_logoutActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
    int a = JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "COMPUTER DEPARTMENT", JOptionPane.YES_NO_OPTION);

      if (a == JOptionPane.YES_OPTION) {
          try {
              client.close();  
              System.out.println("Client Disconnected.");
          } catch (Exception e) {
              e.printStackTrace();
          }

          this.dispose();     
          System.exit(0);     
      }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
       
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
     
    }//GEN-LAST:event_jPanel2MousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void spFatherNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spFatherNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spFatherNameTFActionPerformed

    private void spYearSectionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spYearSectionTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spYearSectionTFActionPerformed

    private void spCourseTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spCourseTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spCourseTFActionPerformed

    private void spSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spSearchBTNActionPerformed
        String searchQuery = spSearchStudentTF.getText();
        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search query.");
            return;
        }

        try {
            client.sendCommand("SEARCH:" + searchQuery);

            String serverResponse = client.readResponse();
            Studentthreader.searchStudent(spSearchStudentTF, (DefaultTableModel) spTable.getModel());
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
        }
    }//GEN-LAST:event_spSearchBTNActionPerformed

    private void spUpdateBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spUpdateBTNActionPerformed
        StudentThreader st = new StudentThreader();
        st.updateStudent(spIDTF, spNameTF, spCourseTF, spYearSectionTF, spGender, spDateOfBirth, spAddressTF,
                         spEmailTF, spPhoneNumberTF, spFatherNameTF, spMotherNameTF);

        try {
            client.sendCommand("UPDATE:" + spIDTF.getText()); 
            String serverResponse = client.readResponse();

            if (serverResponse.equals("Update successful")) {
                spIDTF.setText("");
                spNameTF.setText("");
                spCourseTF.setText("");
                spYearSectionTF.setText("");
                spAddressTF.setText("");
                spEmailTF.setText("");
                spPhoneNumberTF.setText("");
                spFatherNameTF.setText("");
                spMotherNameTF.setText("");

                spGender.setSelectedIndex(0);
                spDateOfBirth.setDate(null);

            } else {
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error during update: " + ex.getMessage());
        }
    }//GEN-LAST:event_spUpdateBTNActionPerformed

    private void spUndoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spUndoBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) spTable.getModel();
        Studentthreader.undoDelete(model);
    }//GEN-LAST:event_spUndoBTNActionPerformed

    private void spDeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spDeleteBTNActionPerformed
        try {
        int selectedRow = spTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentID = spTable.getValueAt(selectedRow, 0).toString();

            client.sendCommand("DELETE_STUDENT:" + studentID);
            String serverResponse = client.readResponse();

            if (serverResponse.contains("Delete command received")) {
                DefaultTableModel model = (DefaultTableModel) spTable.getModel();
                Studentthreader.deleteStudent(spTable, model);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a student to delete.");
        }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
        }
    }//GEN-LAST:event_spDeleteBTNActionPerformed

    private void course5JComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course5JComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course5JComboActionPerformed

    private void course4JComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course4JComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course4JComboActionPerformed

    private void course3JComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course3JComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course3JComboActionPerformed

    private void course2JComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course2JComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course2JComboActionPerformed

    private void course1JComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course1JComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course1JComboActionPerformed

    private void semesterJcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterJcomboActionPerformed
        // TODO add your handling code here:
        String courseInput = CourseTF.getText().trim();        
        String yearSectionInput = YearSectionTF.getText().trim(); 
        String semesterInput = semesterJcombo.getSelectedItem().toString();

        String programKey = "";
        if (courseInput.equalsIgnoreCase("BS Computer Science")) {
            programKey = "BSCS";
        } else if (courseInput.equalsIgnoreCase("BS Information Systems")) {
            programKey = "BSIS";
        } else if (courseInput.equalsIgnoreCase("BS Information Technology")) {
            programKey = "BSIT";
        }

        String yearKey = "";
        if (yearSectionInput.startsWith("1")) {
            yearKey = "1st Year";
        } else if (yearSectionInput.startsWith("2")) {
            yearKey = "2nd Year";
        } else if (yearSectionInput.startsWith("3")) {
            yearKey = "3rd Year";
        } else if (yearSectionInput.startsWith("4")) {
            yearKey = "4th Year";
        }

        String courseKey = programKey + "-" + yearKey + "-" + semesterInput;

        String[] selectedCourses = courseMap.get(courseKey);
        JComboBox[] comboBoxes = {
            course1JCombo, course2JCombo, course3JCombo, course4JCombo, course5JCombo
        };

        if (selectedCourses != null) {
            for (int i = 0; i < comboBoxes.length; i++) {
                comboBoxes[i].removeAllItems();
                comboBoxes[i].addItem(selectedCourses[i]);
            }
        } else {
            for (JComboBox combo : comboBoxes) {
                combo.removeAllItems();
            }
            JOptionPane.showMessageDialog(this, "No courses found for: " + courseKey);
        }
    }//GEN-LAST:event_semesterJcomboActionPerformed

    private void courseStudIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseStudIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseStudIDTFActionPerformed

    private void courseAcadYearTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseAcadYearTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseAcadYearTFActionPerformed

    private void courseSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSaveBTNActionPerformed
        String studID = courseStudIDTF.getText().trim();
        String acadYear = courseAcadYearTF.getText().trim();
        String yearSection = YearSectionTF.getText().trim();  
        String course = CourseTF.getText().trim();             

        String semester = getSelectedItemString(semesterJcombo);
        String course1 = getSelectedItemString(course1JCombo);
        String course2 = getSelectedItemString(course2JCombo);
        String course3 = getSelectedItemString(course3JCombo);
        String course4 = getSelectedItemString(course4JCombo);
        String course5 = getSelectedItemString(course5JCombo);

        if (studID.isEmpty() || acadYear.isEmpty() || yearSection.isEmpty() || course.isEmpty() ||
            semester == null || course1 == null || course2 == null ||
            course3 == null || course4 == null || course5 == null) {

            JOptionPane.showMessageDialog(this, "Please fill in all fields before saving.");
            return;
        }

        String courseData = studID + "," + acadYear + "," + semester + "," +
                            course1 + "," + course2 + "," + course3 + "," +
                            course4 + "," + course5;

        try {
            client.sendCommand("COURSESAVE:" + courseData);

            String serverResponse = client.readResponse();
            
            courseThreader.save(courseStudIDTF, courseAcadYearTF, semesterJcombo,
                                course1JCombo, course2JCombo, course3JCombo,
                                course4JCombo, course5JCombo, courseTable,
                                YearSectionTF, CourseTF); 

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred while saving data.");
        }
    }


        private String getSelectedItemString(JComboBox<String> comboBox) {
            Object selectedItem = comboBox.getSelectedItem();
            return (selectedItem != null) ? selectedItem.toString() : null;    
    }//GEN-LAST:event_courseSaveBTNActionPerformed

    private void courseSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSearchBTNActionPerformed
        String searchQuery = courseSearchTF.getText().trim();

        if (searchQuery.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a course search query.");
            return;
        }

        try {
            client.sendCommand("COURSESEARCH:" + searchQuery);
            String serverResponse = client.readResponse();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
        }
        courseThreader.search(courseSearchTF, courseTable);
    }//GEN-LAST:event_courseSearchBTNActionPerformed

    private void gradeAcadYearTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeAcadYearTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeAcadYearTFActionPerformed

    private void gradesemesterJcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradesemesterJcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradesemesterJcomboActionPerformed

    private void gwaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gwaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gwaTFActionPerformed

    private void gradeCoursesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeCoursesBTNActionPerformed
         gradeThreader.LoadCourses(gradeStudIDTF, gradeAcadYearTF, gradesemesterJcombo,
                              courseNameTF1, courseNameTF2, courseNameTF3,
                              courseNameTF4, courseNameTF5,
                              courseGradeTF1, courseGradeTF2, courseGradeTF3,
                              courseGradeTF4, courseGradeTF5);
    }//GEN-LAST:event_gradeCoursesBTNActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
    int a = JOptionPane.showConfirmDialog(this, "Do you want to logout now?", "COMPUTER DEPARTMENT", JOptionPane.YES_NO_OPTION);
    
    if (a == JOptionPane.YES_OPTION) {
        try {
            client.close(); 
            System.out.println("Client Disconnected.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.dispose();      
        System.exit(0);          }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void gradeSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeSaveActionPerformed
        String studid = gradeStudIDTF.getText().trim(); 
        String acadYear = gradeAcadYearTF.getText().trim();
        String semester = gradesemesterJcombo.getSelectedItem().toString().trim();

        if (studid.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete Student ID, Academic Year, and Semester fields.");
            return;
        }

        try {
            client.sendCommand("GRADESAVE:" + studid); 
            String serverResponse = client.readResponse();

            if (!serverResponse.toLowerCase().contains("save")) {
                JOptionPane.showMessageDialog(this, "Unexpected response from server: " + serverResponse);
            }

            JTextField[] gradeFields = new JTextField[]{
                courseGradeTF1, courseGradeTF2, courseGradeTF3, courseGradeTF4, courseGradeTF5
            };

            JTextField[] courseFields = new JTextField[]{
                courseNameTF1, courseNameTF2, courseNameTF3, courseNameTF4, courseNameTF5
            };

            gradeThreader.saveGradeAndGWA(studid, acadYear, semester, courseFields, gradeFields);

            gradeStudIDTF.setText("");
            gradeAcadYearTF.setText("");
            gwaTF.setText("");

            for (JTextField field : courseFields) {
                field.setText("");
            }

            for (JTextField field : gradeFields) {
                field.setText("");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with server: " + ex.getMessage());
        }
    }//GEN-LAST:event_gradeSaveActionPerformed

    private void gradeAYTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeAYTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeAYTFActionPerformed

    private void gradeNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeNameTFActionPerformed

    private void gradeIDTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeIDTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradeIDTFActionPerformed

    private void gradeSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeSearchBTNActionPerformed
        String studid = gradeIDTF.getText().trim();  
        String acadYear = gradeAYTF.getText().trim();
        String semester = gradesemesterJcomboSearch.getSelectedItem().toString().trim();

        if (studid.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields: Student ID, Academic Year, and Semester.");
            return;
        }

        try {
            client.sendCommand("GRADESEARCH:" + studid);
            String serverResponse = client.readResponse();

            if (!serverResponse.toLowerCase().contains("search")) {
                JOptionPane.showMessageDialog(this, "Unexpected response from server: " + serverResponse);
            }

            gradeThreader.searchGrades(
                gradeIDTF,
                gradeNameTF,
                gradeAYTF,
                gradesemesterJcomboSearch,
                gradeTable,
                gwaTFDisplay
            );

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with server: " + ex.getMessage());
        }
    }//GEN-LAST:event_gradeSearchBTNActionPerformed

    private void gwaTFDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gwaTFDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gwaTFDisplayActionPerformed

    private void gradeGWABTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeGWABTNActionPerformed
        JTextField[] gradeFields = new JTextField[]{
           courseGradeTF1, courseGradeTF2, courseGradeTF3, courseGradeTF4, courseGradeTF5
        };

        JTextField[] courseFields = new JTextField[]{
            courseNameTF1, courseNameTF2, courseNameTF3, courseNameTF4, courseNameTF5
        };

        double gwa = gradeThreader.calculateGwa(gradeFields, courseFields);
        if (gwa == -1) {
            gwaTF.setText("N/A");
            JOptionPane.showMessageDialog(this, "No valid grades found for GWA.");
        } else {
            gwaTF.setText(String.format("%.2f", gwa));
        }
    }//GEN-LAST:event_gradeGWABTNActionPerformed

    private void gradeUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeUpdateActionPerformed
        String studid = gradeStudIDTF.getText().trim();
        String acadYear = gradeAcadYearTF.getText().trim();
        String semester = gradesemesterJcombo.getSelectedItem().toString().trim();

        if (studid.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete Student ID, Academic Year, and Semester fields.");
            return;
        }

        JTextField[] courseFields = new JTextField[] {
            courseNameTF1, courseNameTF2, courseNameTF3, courseNameTF4, courseNameTF5
        };

        JTextField[] gradeFields = new JTextField[] {
            courseGradeTF1, courseGradeTF2, courseGradeTF3, courseGradeTF4, courseGradeTF5
        };

        try {
            client.sendCommand("GRADEUPDATE:" + studid);

            String serverResponse = client.readResponse();
            if (serverResponse.equalsIgnoreCase("SUCCESS")) {
            } else {
                return;
            }
            gradeThreader.updateGradeAndGwa(studid, acadYear, semester, courseFields, gradeFields);
            
            gradeStudIDTF.setText("");
            gradeAcadYearTF.setText("");
            gwaTF.setText("");

            for (JTextField field : courseFields) {
                field.setText("");
            }

            for (JTextField field : gradeFields) {
                field.setText("");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with server: " + ex.getMessage());
        }
    }//GEN-LAST:event_gradeUpdateActionPerformed

    private void gradesemesterJcomboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradesemesterJcomboSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradesemesterJcomboSearchActionPerformed

    private void courseDeleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseDeleteBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();

        int selectedRow = courseTable.getSelectedRow();
        if (selectedRow != -1) {
            String studentID = courseTable.getValueAt(selectedRow, 0).toString(); // Assuming first column is student ID

            try {
                client.sendCommand("COURSEDELETE:" + studentID);

                String serverResponse = client.readResponse();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
            }
        }
        courseThreader.deleteCourse(courseTable, model);
    }//GEN-LAST:event_courseDeleteBTNActionPerformed

    private void printRFBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printRFBTNActionPerformed
        String studentID = gradeIDTF.getText().trim();
        String acadYear = gradeAYTF.getText().trim();
        String semester = gradesemesterJcomboSearch.getSelectedItem().toString().trim();

        if (studentID.isEmpty() || acadYear.isEmpty() || semester.isEmpty()) {
            JOptionPane.showMessageDialog(Home.this, "Please fill in all fields.");
            return;
        }

        String requestData = studentID + "," + acadYear + "," + semester;

        try {
            client.sendCommand("PRINTREQUEST:" + requestData);
            String serverResponse = client.readResponse();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
        }
        RFThreader rfThreader = new RFThreader();
        rfThreader.launchRF(studentID, acadYear, semester);
    }//GEN-LAST:event_printRFBTNActionPerformed

    private void gradeTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_gradeTableAncestorAdded
        // TODO add your handling code here:
        gradeTable.getColumnModel().getColumn(0).setPreferredWidth(200);
    }//GEN-LAST:event_gradeTableAncestorAdded

    private void dropCourseBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropCourseBTNActionPerformed
        DefaultTableModel model = (DefaultTableModel) courseTable.getModel();
        int selectedRow = courseTable.getSelectedRow();

        if (selectedRow != -1) {
            String studentID = courseTable.getValueAt(selectedRow, 0).toString(); 

            try {
                client.sendCommand("COURSEDROP:" + studentID);

                String serverResponse = client.readResponse();
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error communicating with the server: " + ex.getMessage());
                return;
            }

            courseThreader.dropCourse(courseTable, model); 
        } else {
            JOptionPane.showMessageDialog(this, "Please select a course to drop.");
        }
    }//GEN-LAST:event_dropCourseBTNActionPerformed

    private void CourseTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CourseTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CourseTFActionPerformed

    private void semesterJcombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterJcombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesterJcombo1ActionPerformed

    private void course1JCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course1JCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course1JCombo1ActionPerformed

    private void course2JCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course2JCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course2JCombo1ActionPerformed

    private void course3JCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course3JCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course3JCombo1ActionPerformed

    private void course4JCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course4JCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course4JCombo1ActionPerformed

    private void course5JCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course5JCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course5JCombo1ActionPerformed

    private void YearSectionTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YearSectionTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_YearSectionTFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CourseTF;
    private javax.swing.JTextField YearSectionTF;
    private javax.swing.JComboBox<String> course1JCombo;
    private javax.swing.JComboBox<String> course1JCombo1;
    private javax.swing.JComboBox<String> course2JCombo;
    private javax.swing.JComboBox<String> course2JCombo1;
    private javax.swing.JComboBox<String> course3JCombo;
    private javax.swing.JComboBox<String> course3JCombo1;
    private javax.swing.JComboBox<String> course4JCombo;
    private javax.swing.JComboBox<String> course4JCombo1;
    private javax.swing.JComboBox<String> course5JCombo;
    private javax.swing.JComboBox<String> course5JCombo1;
    private javax.swing.JTextField courseAcadYearTF;
    private javax.swing.JButton courseDeleteBTN;
    private javax.swing.JTextField courseGradeTF1;
    private javax.swing.JTextField courseGradeTF2;
    private javax.swing.JTextField courseGradeTF3;
    private javax.swing.JTextField courseGradeTF4;
    private javax.swing.JTextField courseGradeTF5;
    private javax.swing.JTextField courseNameTF1;
    private javax.swing.JTextField courseNameTF2;
    private javax.swing.JTextField courseNameTF3;
    private javax.swing.JTextField courseNameTF4;
    private javax.swing.JTextField courseNameTF5;
    private javax.swing.JPanel coursePANEL;
    private javax.swing.JButton courseRefreshBTN;
    private javax.swing.JButton courseSaveBTN;
    private javax.swing.JButton courseSearchBTN;
    private javax.swing.JTextField courseSearchTF;
    private javax.swing.JTextField courseStudIDTF;
    private javax.swing.JTable courseTable;
    private javax.swing.JButton dropCourseBTN;
    private javax.swing.JTextField gradeAYTF;
    private javax.swing.JTextField gradeAcadYearTF;
    private javax.swing.JButton gradeCoursesBTN;
    private javax.swing.JButton gradeGWABTN;
    private javax.swing.JTextField gradeIDTF;
    private javax.swing.JTextField gradeNameTF;
    private javax.swing.JButton gradeSave;
    private javax.swing.JButton gradeSearchBTN;
    private javax.swing.JTextField gradeStudIDTF;
    private javax.swing.JTable gradeTable;
    private javax.swing.JButton gradeUpdate;
    private javax.swing.JPanel gradesPANEL;
    private javax.swing.JComboBox<String> gradesemesterJcombo;
    private javax.swing.JComboBox<String> gradesemesterJcomboSearch;
    private javax.swing.JTextField gwaTF;
    private javax.swing.JTextField gwaTFDisplay;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton27;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton logout;
    private javax.swing.JButton printRFBTN;
    private javax.swing.JComboBox<String> semesterJcombo;
    private javax.swing.JComboBox<String> semesterJcombo1;
    private javax.swing.JTextField spAddressTF;
    private javax.swing.JTextField spCourseTF;
    private com.toedter.calendar.JDateChooser spDateOfBirth;
    private javax.swing.JButton spDeleteBTN;
    private javax.swing.JTextField spEmailTF;
    private javax.swing.JTextField spFatherNameTF;
    private javax.swing.JComboBox<String> spGender;
    private javax.swing.JTextField spIDTF;
    private javax.swing.JTextField spMotherNameTF;
    private javax.swing.JTextField spNameTF;
    private javax.swing.JTextField spPhoneNumberTF;
    private javax.swing.JButton spRefreshBTN;
    private javax.swing.JButton spSaveBTN;
    private javax.swing.JButton spSearchBTN;
    private javax.swing.JTextField spSearchStudentTF;
    private javax.swing.JTable spTable;
    private javax.swing.JButton spUndoBTN;
    private javax.swing.JButton spUpdateBTN;
    private javax.swing.JTextField spYearSectionTF;
    private javax.swing.JPanel studentPANEL;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
