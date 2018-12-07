//
//  ViewController.swift
//  iOSApp
//
//  Created by NAVER on 30/11/2018.
//  Copyright © 2018 myungpyo. All rights reserved.
//

import UIKit
import SharedCode

class MemoViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let label = UILabel(frame: CGRect(x: 0, y: 0, width: 300, height: 21))
        label.center = CGPoint(x: 160, y: 285)
        label.textAlignment = .center
        label.font = label.font.withSize(25)
        label.text = CommonKt.createWelcomeMessage()
        view.addSubview(label)
        
    }


}




