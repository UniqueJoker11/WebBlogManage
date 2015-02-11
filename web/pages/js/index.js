/**
 * Created by Administrator on 2014/12/26.
 */
var content=new Array(1,3,43,4,45,5,6,67,7,56,78,8,88,9,45,34,3,3,56,3,4,4,5,5,89,5,5,123,5,5,5,5,5,5,5,5,57,8,6,7,8,89,234,6,78,7654,654,5,76,54,1234,786,65,4,35,433,3,3,3,3,7,5,6,7,8,8);
$(function(){
    console.log("istjtyj");
    //提交应用请求
$("#submitUrlContent").bind("submit",function(e){
    var params=new Object();
    params.urlAddress=encodeURI($(this).find("input[name='urlAddress']").val());
    $.post("/WebManage/action/urlContentParse.do",params,function(data){
        var result= $.parseJSON(data);
        if(result.isSuccess){
$("#showContent").html(result.result);
        }else{
$("#showContent").html("获取网页信息失败！");
        }
    });
    console.log("helloeekgeot");
    e.preventDefault();
    return false;
});
    var page=function(params){
        var defaultParams=new Object();
        defaultParams.currentPage=1;
        defaultParams.pageSize=10;
        defaultParams.flag=2; //分页模式,1:根据字数自动分页 2:根据[NextPage]分页
        defaultParams.stratPage=1;
    }
    //设计一个分页算法，该算法一次性加在所有的数据，然后对数据进行分页。
    function initPageSplit(){

    }
});
