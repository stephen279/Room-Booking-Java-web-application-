var xmlHttp

function showHint(str)
{         // AJAX file for searching for info with locations inside ajaxform.jsp
    if (str.length >= 1)
    { 
        var url="/DatabaseTest/Search?sid=" + Math.random() + "&q=" + str
        xmlHttp=GetXmlHttpObject(stateChanged)
        xmlHttp.open("GET", url , true)
        xmlHttp.send(null)
    } 
    else
    { 
        document.getElementById("txtHint").innerHTML="No Suggestions";
    } 
} 

function stateChanged() 
{ 
    if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete")
    { 
        document.getElementById("txtHint").innerHTML=xmlHttp.responseText 
    } 
} 

function GetXmlHttpObject(handler)
{ 
    var objXmlHttp=null
    // Just going to deal with MSIE and Mozilla for the sake of brevity
    if (navigator.userAgent.indexOf("MSIE")>=0)
    { 
        var strName="Msxml2.XMLHTTP"
        if (navigator.appVersion.indexOf("MSIE 5.5")>=0)
        {
            strName="Microsoft.XMLHTTP"
        } 
        try
        { 
            objXmlHttp=new ActiveXObject(strName)
            objXmlHttp.onreadystatechange=handler 
            return objXmlHttp
        } 
        catch(e)
        { 
            /**
			 * This gets caught if Scripting for ActiveX isn't enabled as a
			 * possibility *
			 */
            return 
        } 
    }

    if (navigator.userAgent.indexOf("Mozilla")>=0)
    {
        objXmlHttp=new XMLHttpRequest()
        objXmlHttp.onload=handler
        objXmlHttp.onerror=handler 
        return objXmlHttp
    }
} 





