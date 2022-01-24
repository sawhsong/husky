<%/************************************************************************************************
* Description - Bau0202 - My Bank Accounts
*	- Generated by Source Generator
************************************************************************************************/%>
<%@ include file="/shared/page/incCommon.jsp"%>
<%/************************************************************************************************
* Declare objects & variables
************************************************************************************************/%>
<%
	ParamEntity paramEntity = (ParamEntity)request.getAttribute("paramEntity");
	DataSet requestDataSet = (DataSet)paramEntity.getRequestDataSet();
	String bankAccntId = requestDataSet.getValue("bankAccntId");
%>
<%/************************************************************************************************
* HTML
************************************************************************************************/%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="icon" type="image/png" href="<mc:cp key="imgIcon"/>/faviconHKAccount.png">
<title><mc:msg key="main.system.title"/></title>
<%/************************************************************************************************
* Stylesheet & Javascript
************************************************************************************************/%>
<%@ include file="/shared/page/incCssJs.jsp"%>
<style type="text/css">
</style>
<script type="text/javascript" src="<mc:cp key="viewPageJsName"/>"></script>
<script type="text/javascript">
var bankAccntId = "<%=bankAccntId%>";
</script>
</head>
<%/************************************************************************************************
* Page & Header
************************************************************************************************/%>
<body>
<form id="fmDefault" name="fmDefault" method="post" action="">
<div id="divPopupWindowHolder">
<div id="divFixedPanelPopup">
<div id="divLocationPathArea"><%@ include file="/project/common/include/bodyLocationPathArea.jsp"%></div>
<%/************************************************************************************************
* Real Contents - fixed panel(tab, button, search, information)
************************************************************************************************/%>
<div id="divTabArea"></div>
<div id="divButtonArea" class="areaContainerPopup">
	<div id="divButtonAreaLeft"></div>
	<div id="divButtonAreaRight">
		<ui:buttonGroup id="buttonGroup">
			<ui:button id="btnSave" caption="button.com.save" iconClass="fa-save"/>
			<ui:button id="btnClose" caption="button.com.close" iconClass="fa-times"/>
		</ui:buttonGroup>
	</div>
</div>
<div id="divSearchCriteriaArea"></div>
<div id="divInformArea"></div>
<%/************************************************************************************************
* End of fixed panel
************************************************************************************************/%>
<div class="breaker"></div>
</div>
<div id="divScrollablePanelPopup">
<%/************************************************************************************************
* Real Contents - scrollable panel(data, paging)
************************************************************************************************/%>
<div id="divDataArea" class="areaContainerPopup">
	<table class="tblEdit">
		<colgroup>
			<col width="17%"/>
			<col width="33%"/>
			<col width="17%"/>
			<col width="33%"/>
		</colgroup>
		<tr>
			<th class="thEdit rt mandatory">Bank</th>
			<td class="tdEdit" colspan="3">
				<ui:hidden name="bankAccntId"/>
				<ui:ccselect name="bankCode" checkName="Bank" codeType="BANK_TYPE" options="mandatory"/>
			</td>
		</tr>
		<tr>
			<th class="thEdit rt mandatory">BSB</th>
			<td class="tdEdit"><ui:text name="bsb" className="Ct" style="width:50%" checkName="BSB" options="mandatory" option="numeric"/></td>
			<th class="thEdit rt mandatory">Account Number</th>
			<td class="tdEdit"><ui:text name="accntNumber" className="Lt" checkName="Account Number" options="mandatory" option="numeric"/></td>
		</tr>
		<tr>
			<th class="thEdit rt mandatory">Account Name</th>
			<td class="tdEdit"><ui:text name="accntName" className="Lt" checkName="Account Name" options="mandatory"/></td>
			<th class="thEdit rt">Balance</th>
			<td class="tdEdit"><ui:text name="balance" className="Rt numeric" option="numeric"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">Description</th>
			<td class="tdEdit" colspan="3"><ui:text name="description" className="Lt"/></td>
		</tr>
		<tr>
			<th class="thEdit rt">Last Updated By</th>
			<td class="tdEdit"><ui:text name="lastUpdatedBy" status="display"/></td>
			<th class="thEdit rt">Last Updated Date</th>
			<td class="tdEdit"><ui:text name="lastUpdatedDate" status="display"/></td>
		</tr>
	</table>
</div>
<div id="divPagingArea"></div>
<%/************************************************************************************************
* Right & Footer
************************************************************************************************/%>
</div>
</div>
<%/************************************************************************************************
* Additional Elements
************************************************************************************************/%>
</form>
<%/************************************************************************************************
* Additional Form
************************************************************************************************/%>
<form id="fmHidden" name="fmHidden" method="post" action=""></form>
</body>
</html>