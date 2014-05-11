package cn.szboc.platform.core;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class Page
{
	// 当前页
	private int					currentPage				= 1;

	// 总页数
	private int					totalPages				= 10;

	// 每页10条数据
	private int					pageRecorders			= 15;

	// 总数据数
	private int					totalRows				= 0;

	// 参数
	private String				paras;

	private String				dbType					= "";

	private String				advancedSelectCondition	= "";

	private String				advancedSortCondition	= "";

	/**
	 * 20090707：基于分页层次的“排序”SQL语句，当该排序SQL不为空时，在分页查询之后，按该排序语句对查询结果进行排序。
	 */
	public static final String	ORDER_BY_SQL_PARAM		= "orderBySql";
	private String				orderBySql;

	public Page()
	{
	}

	private void adjustTotalPages()
	{
		totalPages = totalRows / pageRecorders;
		if ((totalRows % pageRecorders) != 0)
		{
			totalPages++;
		}
	}

	/**
	 * 生成page对象
	 *
	 * @param currentpageno
	 *            当前第几页
	 * @param pagerecord
	 *            每页显示记录数
	 */
	public Page(int currentpageno, int pagerecord)
	{
		currentPage = currentpageno;
		pageRecorders = pagerecord;
	}

	/**
	 * @return Returns the currentPage.
	 */
	public String getCurrentPage()
	{
		return String.valueOf(currentPage);
	}

	public int getPageRecorders()
	{
		return pageRecorders;
	}

	public void setPageRecorders(int pageRecorders)
	{
		this.pageRecorders = pageRecorders;
		adjustTotalPages();
	}

	public String getTotalPages()
	{
		return String.valueOf(totalPages);
	}

	public String getTotalRows()
	{
		return String.valueOf(totalRows);
	}

	/**
	 * @param currentPage
	 *            The currentPage to set.
	 */
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	/**
	 * @param totalPages
	 *            The totalPages to set.
	 */
	public void setTotalPages(int totalPages)
	{
		this.totalPages = totalPages;
		adjustTotalPages();
	}

	/**
	 * @param totalRows
	 *            The totalRows to set.
	 */
	public void setTotalRows(int totalRows)
	{
		this.totalRows = totalRows;
		adjustTotalPages();
	}

	/**
	 * @return Returns the hasNextPage.
	 */
	public boolean isHasNextPage()
	{
		if (currentPage >= totalPages)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * @return Returns the hasPreviousPage.
	 */
	public boolean isHasPreviousPage()
	{
		if (currentPage > 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return Returns the hasFirstPage.
	 */
	public boolean isHasFirstPage()
	{
		if (currentPage != 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return Returns the hasLastPage.
	 */
	public boolean isHasLastPage()
	{
		if (currentPage < totalPages)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return Returns the pageSize. 供struts tag中取字符型的每页记录数
	 */
	public String getPageSize()
	{
		return (new Integer(pageRecorders).toString());
	}

	public String getParas()
	{
		return paras;
	}

	public void setParas(String paras)
	{
		this.paras = paras;
	}

	public String getAdvancedSelectCondition()
	{
		return advancedSelectCondition;
	}

	public void setAdvancedSelectCondition(String advancedSelectCondition)
	{
		this.advancedSelectCondition = advancedSelectCondition;
	}

	public String getAdvancedSortCondition()
	{
		return advancedSortCondition;
	}

	public void setAdvancedSortCondition(String advancedSortCondition)
	{
		this.advancedSortCondition = advancedSortCondition;
	}

	public String getDbType()
	{
		return dbType;
	}

	public void setDbType(String dbType)
	{
		this.dbType = dbType;
	}

	@SuppressWarnings("unchecked")
	public void parsePaginationPara(HttpServletRequest request)
	{
		if (request == null)
		{
			throw new RuntimeException("参数request不允许为null");
		}

		String currentPage = request.getParameter("currentPage");

		StringBuffer parameter = new StringBuffer();
		Enumeration<String> enumeration = request.getParameterNames();

		// 取出参数
		while (enumeration.hasMoreElements())
		{
			String parameterName = enumeration.nextElement();

			if ("currentPage".equalsIgnoreCase(parameterName)
					&& !"method".equalsIgnoreCase(parameterName))
			{
				parameter.append(parameterName);
				parameter.append('=');
				parameter.append(request.getParameter(parameterName));
				parameter.append('&');
			}
		}

		if (parameter.length() != 0)
		{
			parameter.deleteCharAt(parameter.length() - 1);

		}

		setParas(parameter.toString());

		// request.getSession().setAttribute("SystemUserOperList",request.getRequestURI()+"?"+paras);

		try
		{
			if (currentPage == null || currentPage.equals("null")
					|| currentPage.equals(""))
			{
				setCurrentPage(1);
			}
			else
			{

				setCurrentPage(Integer.parseInt(currentPage));
			}
		}
		catch (Exception e)
		{
			setCurrentPage(1);
		}
		if (request.getParameter("advancedSelectCondition") != null)
		{
			setAdvancedSelectCondition(" "
					+ request.getParameter("advancedSelectCondition"));
		}
		if (request.getParameter("advancedSortCondition") != null)
		{
			setAdvancedSortCondition(" "
					+ request.getParameter("advancedSortCondition"));
		}
		request.setAttribute("pageParam", this);

	}

	/**
	 * @return the orderBySql
	 */
	public String getOrderBySql()
	{
		return orderBySql;
	}

	/**
	 * @param orderBySql
	 *            the orderBySql to set
	 */
	public void setOrderBySql(String orderBySql)
	{
		this.orderBySql = orderBySql;
	}
}
