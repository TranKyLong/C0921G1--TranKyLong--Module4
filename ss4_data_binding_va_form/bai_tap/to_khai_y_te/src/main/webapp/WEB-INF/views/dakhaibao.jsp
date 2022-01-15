<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>

    <link rel="stylesheet" href="../../assert/css/ToKhaiYte.css" type="text/css">
    <link rel="stylesheet" href="../../assert/boostrap/css/bootstrap.min.css">
    <style>
        input{
            pointer-events: none;
            background: #bababa;
            border: #545d65;
            color:black ;
        }
        input:focus{
            outline: none;
        }
        body{
            background: #c2ceff;
        }
    </style>
</head>
<body>
<div class="text-center" >
    <strong>TỜ KHAI Y TẾ</strong> <br>
    <strong>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CÀN THIẾT ĐỂ PHÒNG CHÓNG
        DỊCH BỆNH TRUYỀN NHIÊM</strong>
    <strong class="text-danger"> Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình
        sự </strong>
    <h4 class="text-success"> KHAI BÁO THÀNH CÔNG</h4>
</div>

<form:form action="/khaibaolai"  method="post" modelAttribute="tokhaicomplete" cssClass="align-content-center">
    <fieldset >
        <div class="container">
            <p>Họ tên (ghi chữ IN HOA) <span class="batbuoc">(*)</span></p>
            <form:input path="hoTen" readonly="true"/>
            <table>
                <tr>
                    <td>
                        <p>Năm sinh <span class="batbuoc">(*)</span></p>
                        <form:input path="namSinh" cssClass="inputfull"/>

                    </td>
                    <td>
                        <p>Giới tính <span class="batbuoc">(*)</span></p>
                        <form:select path="gioiTinh">
                            <option value="1"> Nam</option>
                            <option value="2"> Nữ</option>
                        </form:select>


                    </td>
                    <td>
                        <p>Quốc Tịch <span class="batbuoc">(*)</span></p>
                        <form:input path="quocTich" cssClass="inputfull"/>
                    </td>
                </tr>
            </table>
            <div class="align-content-start">
                <p>Thông tin đi lại <span class="batbuoc">(*)</span></p>
                <form:radiobutton path="thongTinDiLai" value="Tàu bay" label="Tàu bay "/>
                <form:radiobutton path="thongTinDiLai" value="Tàu Thuyền" label="Tàu Thuyền "/>
                <form:radiobutton path="thongTinDiLai" value="Ô tô" label="Ô tô"/>
                <form:radiobutton path="thongTinDiLai" value="Khác" label="Khác"/>
            </div>

            <table>
                <tr>
                    <td>
                        <p>Số hiệu phương tiện</p>
                        <form:input path="soHieu" cssClass="inputfull"/>
                    </td>
                    <td>
                        <p>Số ghế</p>
                        <form:input path="soGhe"/>
                    </td>
                </tr>
                <tr>
                    <td><p>Ngày khởi hành</p>
                        <form:input path="ngayKhoiHanh" cssClass="inputfull"/>
                    </td>
                    <td>
                        <p>Ngày Kết thúc</p>
                        <form:input path="ngayKetThuc" cssClass="inputfull"/>
                    </td>
                </tr>
            </table>


            <p> Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? <span class="batbuoc">(*)</span></p>
            <form:input path="tpDaDen"/>

            <p>Địa chỉ liên lạc</p>
            <table>
                <tr>
                    <td><p>Tỉnh thành <span class="batbuoc">(*)</span></p>
                        <form:input path="tinhThanh" cssClass="inputfull"/></td>
                    <td><p>Quận/Huyện <span class="batbuoc">(*)</span></p>
                        <form:input path="quanHuyen" cssClass="inputfull"/></td>
                    <td><p>Phường/xã<span class="batbuoc">(*)</span></p>
                        <form:input path="phuongXa" cssClass="inputfull"/></td>
                </tr>
                <tr>
                    <td colspan="3">
                        <p>Địa chỉ nơi ở <span class="batbuoc">(*)</span></p>
                        <form:input path="diaChi"/>
                    </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>
                        <p>Điện thoại<span class="batbuoc">(*)</span></p>
                        <form:input path="sdt" cssClass="inputfull"/>

                    </td>
                    <td>
                        <p>Email </p>
                        <form:input path="mail" cssClass="inputfull"/>

                    </td>
                </tr>
            </table>
            <p>Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện dấu hiệu nào sau đây không?<span
                    class="batbuoc">(*)</span>
            </p>

            <table class="trieuchung">
                <tr>
                    <td class="tieude">Triệu chứng</td>
                    <td class="tieude">Có</td>
                    <td class="tieude">Không</td>
                    <td class="tieude">Triệu chứng</td>
                    <td class="tieude">Có</td>
                    <td class="tieude">Không</td>

                </tr>
                <tr>
                    <td><p>Sốt<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="sot" value="true"/></td>
                    <td><form:radiobutton path="sot" value="false"/></td>
                    <td><p>Nôn/Buồn nôn<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="buonNon" value="true"/></td>
                    <td><form:radiobutton path="buonNon" value="false"/></td>

                </tr>
                <tr>
                    <td><p>Ho<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="ho" value="true"/></td>
                    <td><form:radiobutton path="ho" value="false"/></td>
                    <td><p>Tiêu chảy<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="tieuChay" value="true"/></td>
                    <td><form:radiobutton path="tieuChay" value="false"/></td>
                </tr>
                <tr>
                    <td ><p>Khó thở<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="khoTho" value="true"/></td>
                    <td><form:radiobutton path="khoTho" value="false"/></td>
                    <td><p>Xuất huyết ngoài da<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="xuatHuyet" value="true"/></td>
                    <td><form:radiobutton path="xuatHuyet" value="false"/></td>
                </tr>
                <tr>
                    <td><p>Đau họng<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="dauHong" value="true"/></td>
                    <td><form:radiobutton path="dauHong" value="false"/></td>
                    <td><p>Nổi ban ngoài da<span class="batbuoc">(*)</span></p></td>
                    <td><form:radiobutton path="phatBan" value="true"/></td>
                    <td><form:radiobutton path="phatBan" value="false"/></td>
                </tr>
            </table>
            <p> Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh/Chị có<span class="batbuoc">(*)</span></p>
            <table>
                <tr>
                    <td class="tieude"></td>
                    <td class="tieude">Có</td>
                    <td class="tieude">Không</td>
                </tr>
                <tr>
                    <td><p> Đến trang trại chăn nuôi / chợ buôn bán động vật sống / cơ sở giết mổ động vật / tiếp xúc
                        động vật
                        <span class="batbuoc">(*)</span></p>
                    </td>
                    <td><form:radiobutton path="dauHong" value="true"/></td>
                    <td><form:radiobutton path="dauHong" value="false"/></td>
                </tr>

                <tr>
                    <td><p>Tiếp xúc gần (<2m) với người mắc bệnh viêm đường hô hấp do nCoV<span
                            class="batbuoc">(*)</span></p>
                    </td>
                    <td><form:radiobutton path="phatBan" value="true"/></td>
                    <td><form:radiobutton path="phatBan" value="false"/></td>
                </tr>

            </table>
            <p class="text-danger">Dữ liệu bạn cung cấp hoàn toàn bảo mật và chỉ phục vụ cho việc phòng chống dịch,
                thuộc quản lý của Ban chỉ đạo quốc gia về Phòng chống dịch Covid-19.
                Khi bạn nhấn nút "Gửi" là bạn đã hiểu và đồng ý.</p>


        </div>
    </fieldset>
    <div class="align-content-center">
        <button type="submit" class="btn btn-success text-white rounded-pill"> KHAI BÁO LẠI</button>
    </div>
</form:form>

<script src="../../assert/boostrap/js/bootstrap.min.js"></script>
</body>
</html>

