//
//  AppDelegate.swift
//  iOSApp
//
//  Created by NAVER on 30/11/2018.
//  Copyright © 2018 myungpyo. All rights reserved.
//

import UIKit
import SharedCode
import Swinject

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    let container: Container = {
        let container = Container()
        container.register(SchedulerProvider.self) { _ in SchedulerProviderImpl() }
        container.register(MemoDataSource.self) { _ in MemoDataSourceImpl() }
        container.register(MemoRepository.self) { r in MemoRepositoryImpl(dataSource: r.resolve(MemoDataSource.self)!) }
        container.register(GetAllMemosUseCase.self) { r in GetAllMemosUseCase(repository: r.resolve(MemoRepository.self)!) }
        container.register(MemoListViewModel.self) { r in MemoListViewModel(
            schedulerProvider: r.resolve(SchedulerProvider.self)!,
            getAllMemosUseCase: r.resolve(GetAllMemosUseCase.self)!
        ) }
        container.register(MemoListViewController.self) { r in
            let controller = MemoListViewController()
            controller.viewModel = r.resolve(MemoListViewModel.self)
            return controller
        }
        return container
    }()

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        let window = UIWindow(frame: UIScreen.main.bounds)
        self.window = window
        self.window?.backgroundColor = .white
        
        self.window?.rootViewController = container.resolve(MemoListViewController.self)
        self.window?.makeKeyAndVisible()
        return true
    }

    func applicationWillResignActive(_ application: UIApplication) {
        // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
        // Use this method to pause ongoing tasks, disable timers, and invalidate graphics rendering callbacks. Games should use this method to pause the game.
    }

    func applicationDidEnterBackground(_ application: UIApplication) {
        // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
        // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
    }

    func applicationWillEnterForeground(_ application: UIApplication) {
        // Called as part of the transition from the background to the active state; here you can undo many of the changes made on entering the background.
    }

    func applicationDidBecomeActive(_ application: UIApplication) {
        // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
    }

    func applicationWillTerminate(_ application: UIApplication) {
        // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
    }


}

