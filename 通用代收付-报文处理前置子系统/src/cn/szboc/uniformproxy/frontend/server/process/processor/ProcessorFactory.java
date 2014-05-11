package cn.szboc.uniformproxy.frontend.server.process.processor;

import cn.szboc.uniformproxy.frontend.system.SysReg;
import cn.szboc.uniformproxy.remoteinvoke.jaxb.bean.TTRANSMSGTYPE;

public class ProcessorFactory {

	public static Processor getProcessor(TTRANSMSGTYPE type) throws Exception{
		
		if(type == null){
			throw new NullPointerException("请求Bean不能为空");
		}
		
		switch(type){
			case A_001:
				return SysReg.get("A001_Processor", A001_Processor.class);
			case A_002:
				return SysReg.get("A002_Processor", A002_Processor.class);
			case B_001:
				return SysReg.get("B001_Processor", B001_Processor.class);
			case B_002:
				return SysReg.get("B002_Processor", B002_Processor.class);
			case B_003:
				return SysReg.get("B003_Processor", B003_Processor.class);
			case B_004:
				return SysReg.get("B004_Processor", B004_Processor.class);
			case B_005:
				return SysReg.get("B005_Processor", B005_Processor.class);
			case B_101:
				return SysReg.get("B101_Processor", B101_Processor.class);
			case B_102:
				return SysReg.get("B102_Processor", B102_Processor.class);
			case B_104:
				return SysReg.get("B104_Processor", B104_Processor.class);
			case B_105:
				return SysReg.get("B105_Processor", B105_Processor.class);
			case C_001:
				return SysReg.get("C001_Processor", C001_Processor.class);
			case C_002:
				return SysReg.get("C002_Processor", C002_Processor.class);
			case C_003:
				return SysReg.get("C003_Processor", C003_Processor.class);
			case C_004:
				return SysReg.get("C004_Processor", C004_Processor.class);
			case C_102:
				return SysReg.get("C102_Processor", C102_Processor.class);
			case C_103:
				return SysReg.get("C103_Processor", C103_Processor.class);
			case C_104:
				return SysReg.get("C104_Processor", C104_Processor.class);
			default:
				throw new IllegalArgumentException("未找到对应的处理器,请求类型为" + type.value());
		}
	}

}
