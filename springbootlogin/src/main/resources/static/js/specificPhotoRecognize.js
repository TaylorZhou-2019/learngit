$(function() {
    $("#changeResButt").click(function() {
        alert("提交成功，感谢您的反馈！");
    });
    $("#changeCamera").click(function() {
        window.location.href = "camera.html";
    });

    $("#uploadImg").click(function() {
        // progressBar();
        alert("get");
        $("#loading1").removeClass("hidden");
        $.ajaxFileUpload({
            // url: '/Tulip-Quant/file/upload',
            url: '/file/upload',
            type: 'POST',
            secureuri: false, //是否启用安全提交，默认为false  
            fileElementId: 'photoInput', //文件选择框的id属性  
            dataType: 'json', //服务器返回的格式  
            async: false,
            success: function(data) {
                    alert("上传成功！")
                }
            })
        });

    $("#uploadImg1").click(function() {
        // progressBar();
        alert("get");
        $("#loading1").removeClass("hidden");
        $.ajaxFileUpload({
            // url: '/Tulip-Quant/file/upload',
            url: '/file/upload1',
            type: 'POST',
            secureuri: false, //是否启用安全提交，默认为false
            fileElementId: 'photoInput1', //文件选择框的id属性
            dataType: 'json', //服务器返回的格式
            async: false,
            success: function(data) {
                $("#loading").addClass("hidden");
                if(data.match != 1) {
                    alert("图片匹配失败，请重试！")
                    // window.location = "hotelPhoRecg.html";
                }
                else
                    alert("图片匹配成功")
                if(data.suspect == 1) {
                    alert("对方是嫌疑人,请警惕，警方已收到通知，正火速赶来")
                    window.location = "hotelPhoRecg.html"
                }

            else {
                    alert("已通过警局审核，请继续办理业务，谢谢配合")
                    window.location = "hotelPhoRecg.html"
                }
            }
        })
    });
})


function changePhotoResult(data) {
    var i = 0;
    while (data.photoResult[i]) {
        var item = data.photoResult[i]
        var text = "<tr><td>" + item.result + "</td><td>" + item.ratio + "</td></tr>"
        $("#photoResult").append(text);
        i++;
    }
}

function changeStockResult(data) {
    var text1 = "<p>上市公司：" + data.company + "</p>";
    var text2 = "<p>股票代码：" + data.code + "</p>";
    var text3 = "<p>主营业务：" + data.major + "</p>"
    $("#StockResult").prepend(text1, text2, text3);
}

function progressBar() {
    $('h3').text('图像识别中，请稍等...');
    var percentage = 0;
    var interval = setInterval(function() {
        if (percentage < 10000) {
            percentage = percentage + 1;
            var widthTemp = (percentage / 100).toFixed(1) + '%';
            $('#progressBar').css('width', widthTemp);
            $('#progressBar').text(widthTemp);
        } else {
            clearInterval(interval);
            $('h3').text('加载完成！正为您传输结果...');
            setTimeout(function() {
                // location = 'helloWorld.html';
                $('h3').text('识别成功!');
                $("#loading2").addClass("hidden");
                $("#StockResult").removeClass("hidden");
                $("#modalTrigger").removeClass("hidden");
            }, 1500);
        }
    }, 10);
}