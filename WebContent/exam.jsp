<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<%
	int[] numbers = new int[5];
	for (int i = 1; i < 5; i++) {
		numbers[i] = i;
	}

	for (int j = 0; j < 10; j++) {
		int m = (int) (Math.random() * 4 + 1);
		int n = (int) (Math.random() * 4 + 1);
		int p = numbers[m];
		numbers[m] = numbers[n];
		numbers[n] = p;
	}

	for (int k = 1; k <= 4; k++) {
		System.out.print(numbers[k] + "\t");
	}
%>
${PageExamVO.exampage[0].content}
<form action="${pageContext.request.contextPath}/examsession.controller" method="get">
	<div class="question-body clearfix notranslate ">
		
		<c:if test="<%=numbers[1] ==1%>">
			<div class="answer-option-cell">		
				<div class="radio-button-container">
					<input  name="ans" type="radio" class="radio-button-input" value="10"> 
						<label class="answer-label radio-button-label no-touch touch-sensitive clearfix" for="644496188_7455644669"> 
							<span class="radio-button-display"></span> 
							<span class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/></span>
						</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[1]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio" class="radio-button-input" value="0"> 
						<label class="answer-label radio-button-label no-touch touch-sensitive clearfix checked" for="644496188_7455644670"> 
							<span class="radio-button-display"></span> 
							<span class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/></span>
						</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[1]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		
		<c:if test="<%=numbers[1]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644669"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644669"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644669"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		</div>	
	<input type="submit" value="確認送出">
</form>

<div id="paging">
<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="0">
  <tr>
    <td width='76'>
        <c:if test="${PageExamVO.pageNo > 1}">
           <div id="pfirst">
              <a href="<c:url value='/exam.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>
     </td>
     <td width='76'>
        <c:if test="${PageExamVO.pageNo > 1}">
           <div id="pprev">
              <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>  
     </td>
     <td width='76'>
            <c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
                <div id="pnext">
                   <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>  
     <td width='76'>
            <c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
                <div id="plast">
                    <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>
     <td width='176' align="center">
           第${PageExamVO.pageNo}頁 / 共${PageExamVO.totalPages}頁
     </td>  
</tr>
</table>
</div>
</body>
</html>