package org.apache.jsp.pages.instructor;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class studentsTemplate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005finsertDefinition_0026_005fname;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005finsertDefinition_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005finsertDefinition_0026_005fname.release();
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      if (_jspx_meth_f_005floadBundle_005f0(_jspx_page_context))
        return;
      if (_jspx_meth_tiles_005finsertDefinition_005f0(_jspx_page_context))
        return;
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_f_005floadBundle_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  f:loadBundle
    com.sun.faces.taglib.jsf_core.LoadBundleTag _jspx_th_f_005floadBundle_005f0 = (com.sun.faces.taglib.jsf_core.LoadBundleTag) _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody.get(com.sun.faces.taglib.jsf_core.LoadBundleTag.class);
    _jspx_th_f_005floadBundle_005f0.setPageContext(_jspx_page_context);
    _jspx_th_f_005floadBundle_005f0.setParent(null);
    // /pages/instructor/studentsTemplate.jsp(7,58) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_f_005floadBundle_005f0.setVar("msg");
    // /pages/instructor/studentsTemplate.jsp(7,58) name = basename type = javax.el.ValueExpression reqTime = false required = false fragment = false deferredValue = true expectedTypeName = java.lang.String deferredMethod = false methodSignature = null
    _jspx_th_f_005floadBundle_005f0.setBasename(new org.apache.jasper.el.JspValueExpression("/pages/instructor/studentsTemplate.jsp(7,58) 'resources.Messages'",_el_expressionfactory.createValueExpression("resources.Messages",java.lang.String.class)));
    int _jspx_eval_f_005floadBundle_005f0 = _jspx_th_f_005floadBundle_005f0.doStartTag();
    if (_jspx_th_f_005floadBundle_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody.reuse(_jspx_th_f_005floadBundle_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ff_005floadBundle_0026_005fvar_005fbasename_005fnobody.reuse(_jspx_th_f_005floadBundle_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005finsertDefinition_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:insertDefinition
    org.apache.tiles.jsp.taglib.InsertDefinitionTag _jspx_th_tiles_005finsertDefinition_005f0 = (org.apache.tiles.jsp.taglib.InsertDefinitionTag) _005fjspx_005ftagPool_005ftiles_005finsertDefinition_0026_005fname.get(org.apache.tiles.jsp.taglib.InsertDefinitionTag.class);
    _jspx_th_tiles_005finsertDefinition_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005finsertDefinition_005f0.setParent(null);
    // /pages/instructor/studentsTemplate.jsp(9,57) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005finsertDefinition_005f0.setName("page.instructorTemplate");
    int[] _jspx_push_body_count_tiles_005finsertDefinition_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_tiles_005finsertDefinition_005f0 = _jspx_th_tiles_005finsertDefinition_005f0.doStartTag();
      if (_jspx_eval_tiles_005finsertDefinition_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_tiles_005finsertDefinition_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_tiles_005finsertDefinition_005f0[0]++;
          _jspx_th_tiles_005finsertDefinition_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_tiles_005finsertDefinition_005f0.doInitBody();
        }
        do {
          if (_jspx_meth_tiles_005fputAttribute_005f0(_jspx_th_tiles_005finsertDefinition_005f0, _jspx_page_context, _jspx_push_body_count_tiles_005finsertDefinition_005f0))
            return true;
          if (_jspx_meth_tiles_005fputAttribute_005f1(_jspx_th_tiles_005finsertDefinition_005f0, _jspx_page_context, _jspx_push_body_count_tiles_005finsertDefinition_005f0))
            return true;
          int evalDoAfterBody = _jspx_th_tiles_005finsertDefinition_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_tiles_005finsertDefinition_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_tiles_005finsertDefinition_005f0[0]--;
        }
      }
      if (_jspx_th_tiles_005finsertDefinition_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_tiles_005finsertDefinition_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_tiles_005finsertDefinition_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_tiles_005finsertDefinition_005f0.doFinally();
      _005fjspx_005ftagPool_005ftiles_005finsertDefinition_0026_005fname.reuse(_jspx_th_tiles_005finsertDefinition_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_tiles_005fputAttribute_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsertDefinition_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_tiles_005finsertDefinition_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:putAttribute
    org.apache.tiles.jsp.taglib.PutAttributeTag _jspx_th_tiles_005fputAttribute_005f0 = (org.apache.tiles.jsp.taglib.PutAttributeTag) _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.PutAttributeTag.class);
    _jspx_th_tiles_005fputAttribute_005f0.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fputAttribute_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsertDefinition_005f0);
    // /pages/instructor/studentsTemplate.jsp(10,55) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f0.setValue(new String("ProgTest"));
    // /pages/instructor/studentsTemplate.jsp(10,55) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f0.setName("title");
    int _jspx_eval_tiles_005fputAttribute_005f0 = _jspx_th_tiles_005fputAttribute_005f0.doStartTag();
    if (_jspx_th_tiles_005fputAttribute_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fputAttribute_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_tiles_005fputAttribute_005f0);
    return false;
  }

  private boolean _jspx_meth_tiles_005fputAttribute_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_tiles_005finsertDefinition_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_tiles_005finsertDefinition_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  tiles:putAttribute
    org.apache.tiles.jsp.taglib.PutAttributeTag _jspx_th_tiles_005fputAttribute_005f1 = (org.apache.tiles.jsp.taglib.PutAttributeTag) _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody.get(org.apache.tiles.jsp.taglib.PutAttributeTag.class);
    _jspx_th_tiles_005fputAttribute_005f1.setPageContext(_jspx_page_context);
    _jspx_th_tiles_005fputAttribute_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_tiles_005finsertDefinition_005f0);
    // /pages/instructor/studentsTemplate.jsp(12,45) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f1.setValue(new String("/pages/instructor/students.jsp"));
    // /pages/instructor/studentsTemplate.jsp(12,45) name = type type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f1.setType("template");
    // /pages/instructor/studentsTemplate.jsp(12,45) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_tiles_005fputAttribute_005f1.setName("content");
    int _jspx_eval_tiles_005fputAttribute_005f1 = _jspx_th_tiles_005fputAttribute_005f1.doStartTag();
    if (_jspx_th_tiles_005fputAttribute_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody.reuse(_jspx_th_tiles_005fputAttribute_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005ftiles_005fputAttribute_0026_005fvalue_005ftype_005fname_005fnobody.reuse(_jspx_th_tiles_005fputAttribute_005f1);
    return false;
  }
}
