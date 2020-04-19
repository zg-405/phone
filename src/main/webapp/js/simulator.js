function checkPhone() {
    var mobiles = document.getElementById('mobiles').value;
    $.ajax({
        url:"/returnMobile",
        data:{"mobiles":mobiles},
        type:"GET",
        datatype:"json",
        success: function (result) {
            if("status0"==result){
                alert("今日使用次数已用完,请购买独享apikey!")
            }else{
                if("mysqlAndRedis00"==result){
                    alert("数据库/缓存已存入")
                }else if("mysql00Redis01addRedisIsOK"==result){
                    alert("数据库有/缓存没有   已存入")
                }else if("mysql00Redis01addRedisIsError"==result){
                    alert("数据库有/缓存没有   redis插入失败")
                }else if("mysqlRedis"==result){
                    alert("数据库有/缓存有")
                }

            }
            getValue(mobiles);
        },
        error:function () {
            alert("error")
        }
    })

}

function getValue(mobiles) {
    //查询redis  value 根据key
    $.ajax({
        url:"/selectRedisByMobiles",
        data:{"mobiles":mobiles},
        type:"GET",
        datatype:"json",
        success:function (result) {

            $("#getValue").text(result);
        },
        error:function (error) {
            alert("getValueError")
        }
    });
}