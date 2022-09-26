/** 基于bootstrap4.6制作    */
/**判断合适的样式
 function setStyle() {
    //获取屏幕大小
    let screenAvailWidth = window.screen.availWidth;
    //1.最小屏幕:320*568   (iPhone5)  宽<576px
    if (screenAvailWidth > 0 && screenAvailWidth < 576) {
        $("#div_form").addClass("col- offset-2");
        //2.小屏幕:600*960   (Nexus7)   宽≥576px
    } else if (screenAvailWidth >= 576 && screenAvailWidth < 768) {
        $("#div_form").addClass("col-sm-6 offset-sm-3");
        //3.中等屏幕:768*1024   (iPad)   宽≥768px
    } else if (screenAvailWidth >= 768 && screenAvailWidth < 992) {
        $("#div_form").addClass("col-md-6 offset-md-3");
        //4.大屏幕:1080*1340   (Mi 10S)   宽≥992px
    } else if (screenAvailWidth >= 992 && screenAvailWidth < 1200) {
        $("#div_form").addClass("col-lg-4 offset-lg-4");
        //5.超大屏幕:1440*2960   (三星GALAXY S8)   宽>=1200px
    } else if (screenAvailWidth >= 1200) {
        $("#div_form").addClass("col-xl-4 offset-xl-4");
    }
}*/
//获取项目ROOT
function getBasePath() {
    let strPath = window.location.pathname;
    let fullPath = window.location.href;//  http://localhost:8080/ssm_web_Web_exploded/html/login.html
    let pos = fullPath.indexOf(strPath);//21
    let prePath = fullPath.substring(0, pos);//http://localhost:8080
    let postPath = strPath.substring(0, strPath.substring(1).indexOf('/') + 1);//  /ssm_web_Web_exploded
    //http://localhost:8080/ssm_web_Web_exploded
    return prePath + postPath;
}

//登录请求
function login() {
    let user = {
        name: $("#name").val(),
        password: $("#password").val()
    };
    let url = getBasePath() + "/user/login";
    $.ajax({
        type: "GET",
        url: url,
        data: user,
        success: function (resultData) {
            //console.log(resultData);
            if (resultData.status === 200) {
                location.href = getBasePath() + "/student.html";
            } else if (resultData.status === 404) {
                alert(resultData.message);
                location.href = getBasePath() + "/login.html";
            }
        },
        error: function (request) {
            //console.log(request);
            location.href = getBasePath() + "/login.html";
        }
    })
}

//获取学生信息请求
function getStudentInfo() {
    $.ajax({
        type: "GET",
        url: getBasePath() + "/student/all",
        contentType: "application/json",
        success: function (resultData) {
            //console.log(resultData);
            let tbody = $("tbody");
            tbody.empty();
            let student = {
                id: "",
                name: "",
                gender: "",
                birthday: "",
                address: "",
                professionalId: "",
                totalCredits: "",
                remark: "",
            };
            for (let i = 0; i < resultData.length; i++) {
                //console.log(resultData[i]);
                student.id = resultData[i].studentId;
                student.name = resultData[i].studentName;
                if (resultData[i].gender === 1) {
                    student.gender = "男";
                } else if (resultData[i].gender === 0) {
                    student.gender = "女";
                }
                student.birthday = resultData[i].birthday;
                student.address = resultData[i].address;
                student.professionalId = resultData[i].professionalId;
                student.totalCredits = resultData[i].totalCredits;
                student.remark = resultData[i].remark;
                //console.log(student);
                tbody.append("<tr>" +
                    "<th scope=\"row\">" + student.id + "</th>" +
                    "<td>" + student.name + "</td>" +
                    "<td>" + student.gender + "</td>" +
                    "<td>" + student.birthday + "</td>" +
                    "<td>" + student.address + "</td>" +
                    "<td>" + student.professionalId + "</td>" +
                    "<td>" + student.totalCredits + "</td>" +
                    "<td>" + student.remark + "</td>" +
                    "</tr>");
            }
        },
        error: function (request) {
            console.log("ERROR");
        }
    })
}

//添加学生请求
function addStudent() {
    let student = {
        studentId: $("#inputStudentId").val(),
        studentName: $("#inputStudentName").val(),
        gender: $("#inputGender").val(),
        birthday: $("#inputBirthday").val(),
        address: $("#inputAddress").val(),
        professionalId: $("#inputProfessionalId").val(),
        totalCredits: $("#inputTotalCredits").val(),
        remark: $("#inputRemark").val()
    };
    //console.log(student);
    $.ajax({
        type: "POST",
        url: getBasePath() + "/student/addStudent",
        data: student,
        success: function (boolean) {
            if (boolean === true) {
                alert("添加成功!");
                location.href = getBasePath() + "/studentInfo.html";
            } else {
                alert("添加失败!");
            }
        },
        error: function (request) {
            console.log("ERROR");
        }
    })
}

//删除学生请求
function delStudent() {
    //console.log(student);
    //数据json化
    let student = JSON.stringify({studentId: $("#delStudentId").val(), studentName: $("#delStudentName").val()});
    //console.log(student);
    $.ajax({
        type: "DELETE",
        url: getBasePath() + "/student/delStudent",
        data: student,
        //设置发送的数据类型
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (boolean) {
            if (boolean === true) {
                alert("删除成功!");
                location.href = getBasePath() + "/studentInfo.html";
            } else {
                alert("删除失败!")
            }
        },
        error: function (request) {
        }
    })
}

//修改学生信息
function updateStudent() {
    let student = {
        studentId: $("#updateStudentId").val(),
        studentName: $("#updateStudentName").val(),
        gender: $("#updateGender").val(),
        birthday: $("#updateBirthday").val(),
        address: $("#updateAddress").val(),
        professionalId: $("#updateProfessionalId").val(),
        totalCredits: $("#updateTotalCredits").val(),
        remark: $("#updateRemark").val()
    };
    $.ajax({
        url: getBasePath() + "/student/updateStudent",
        method: "PUT",
        data: JSON.stringify(student),
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function (boolean) {
            if (boolean === true) {
                alert("修改成功!");
                location.href = getBasePath() + "/studentInfo.html";
            } else {
                alert("修改失败!")
            }
        },
        error: function (request) {

        }
    })
}